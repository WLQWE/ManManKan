package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.model.recommends.Classification;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SacuraQH on 2016/9/21.
 */
public class RecommendHeaderAdapter extends RecyclerView.Adapter<RecommendHeaderAdapter.ViewHolder> {

    private List<Classification> data;

    private LayoutInflater inflater;

    private ImageOptions options;

    public RecommendHeaderAdapter(Context context) {
        this.data = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        options = new ImageOptions.Builder().setCircular(true).build();
    }

    public void updateRes(List<Classification> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recommend_header_recycler_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        x.image().bind(holder.image, data.get(position).getThumb(), options);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recommend_header_item_image)
        ImageView image;
        @BindView(R.id.recommend_header_item_title)
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
