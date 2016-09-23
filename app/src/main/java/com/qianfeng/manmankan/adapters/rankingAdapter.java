package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.manmankan.model.playermodels.PlayerModel;

import java.util.List;

/**
 * Created by 亚奇 on 2016/9/23.
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private List<PlayerModel.RankTotalBean>  data;

    public RankingAdapter(Context context, List<PlayerModel.RankTotalBean> data) {
        this.data = data;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
