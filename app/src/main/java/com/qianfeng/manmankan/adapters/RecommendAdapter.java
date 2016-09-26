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
 * Created by SacuraQH on 2016/9/23.
 */
public class RecommendAdapter extends BaseRecyclerAdapter<List<Recommendation>> implements View.OnClickListener, RecommendGridAdapter.OnGridItemClickListener {

    private static final String TAG = RecommendAdapter.class.getSimpleName();

    private List<Lists> list=new ArrayList<>();

    private boolean flag;

    private Context context;

    public RecommendAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<Lists> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recommend_recycler_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int position, List<Recommendation> data) {

        if (viewHolder instanceof ViewHolder) {
            ViewHolder holder = (ViewHolder) viewHolder;
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
            RecommendGridAdapter adapter = new RecommendGridAdapter(context, data, flag);
            adapter.setListener(this);
            holder.gridView.setAdapter(adapter);
            holder.btn.setTag(R.id.tag_one, position);
            holder.btn.setTag(R.id.tag_two, adapter);
        }
    }

    public class ViewHolder extends BaseRecyclerAdapter.Holder{

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
}
