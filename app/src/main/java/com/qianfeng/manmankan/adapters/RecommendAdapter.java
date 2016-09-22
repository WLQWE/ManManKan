package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.model.recommends.Lists;
import com.qianfeng.manmankan.model.recommends.Recommendation;
import com.qianfeng.manmankan.ui.PlayerActivity;
import com.qianfeng.manmankan.ui.ProgramaChild;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> implements View.OnClickListener, RecommendGridAdapter.OnGridItemClickListener {

    private static final String TAG = RecommendAdapter.class.getSimpleName();

    private List<List<Recommendation>> data;

    private List<Lists> list;

    private LayoutInflater inflater;

    private Context context;

    private boolean flag;

    public RecommendAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        this.list = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void updateRes(List<List<Recommendation>> data, List<Lists> list) {
        if (data != null && list != null) {
            this.data.clear();
            this.list.clear();
            this.data.addAll(data);
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void addRes(List<List<Recommendation>> data, List<Lists> list) {
        if (data != null && list != null) {
            this.data.addAll(data);
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recommend_recycler_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(" " + list.get(position + 2).getName());
        Drawable right = null;
        if (position != 0) {
            flag = false;
            holder.btn.setText("瞅瞅");
            right = context.getResources().getDrawable(R.drawable.btn_home_content_rignt_cc);
        } else {
            flag = true;
            holder.btn.setText("换一批");
            right = context.getResources().getDrawable(R.drawable.btn_home_content_rignt_huan);
        }
        right.setBounds(0, 0, right.getMinimumWidth(), right.getMinimumHeight());
        holder.btn.setCompoundDrawables(null, null, right, null);
        holder.btn.setOnClickListener(this);
        RecommendGridAdapter adapter = new RecommendGridAdapter(context, data.get(position), flag);
        adapter.setListener(this);
        holder.gridView.setAdapter(adapter);
        holder.btn.setTag(R.id.tag_one, position);
        holder.btn.setTag(R.id.tag_two, adapter);
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag(R.id.tag_one);
        RecommendGridAdapter adapter = (RecommendGridAdapter) v.getTag(R.id.tag_two);
        Log.e(TAG, "onClick: " + position);
        if (position == 0) {
            adapter.changeRes();
        } else {
            Intent intent = new Intent(context, ProgramaChild.class);
            intent.putExtra("name", list.get(position + 2).getName());
            intent.putExtra("slug", list.get(position + 2).getCategory_slug());
            context.startActivity(intent);
        }
    }

    @Override
    public void onItemClick(String uid) {
        Intent intent = new Intent(context, PlayerActivity.class);
        intent.putExtra("uid", uid);
        context.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recommend_recycler_title)
        TextView title;
        @BindView(R.id.recommend_recycler_btn)
        TextView btn;
        @BindView(R.id.recommend_recycler_grid)
        GridView gridView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
