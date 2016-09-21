package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.model.recommends.Lists;
import com.qianfeng.manmankan.model.recommends.Recommendation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {

    private List<Recommendation> data;

    private List<Lists> list;

    private LayoutInflater inflater;

    private Context context;

    public RecommendAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        this.list = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void updateRes(List<Recommendation> data, List<Lists> list) {
        if (data != null && list != null) {
            this.data.clear();
            this.list.clear();
            this.data.addAll(data);
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void addRes(List<Recommendation> data, List<Lists> list) {
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
        holder.title.setText(list.get(position).getName());
        if (position == 0) {
            holder.btn.setText("换一批");
            Drawable right = context.getResources().getDrawable(R.drawable.btn_home_content_rignt_huan);
            right.setBounds(0, 0, right.getMinimumWidth(), right.getMinimumHeight());
            holder.btn.setCompoundDrawables(null, null, right, null);
        }else {

        }
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
