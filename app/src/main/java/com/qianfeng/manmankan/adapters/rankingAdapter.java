package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.model.playermodels.PlayerModel;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 亚奇 on 2016/9/23.
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<PlayerModel.RankTotalBean> data;
    private int id= R.mipmap.top1;
    public RankingAdapter(Context context, List<PlayerModel.RankTotalBean> data) {
       this.data=new ArrayList<>();
        this.data.addAll(data);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
      public void updateRes(List<PlayerModel.RankTotalBean> data){
          if (data!=null) {
              this.data.clear();
              this.data.addAll(data);
              notifyDataSetChanged();
          }

      }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.ranking_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       holder.rankingName.setText(data.get(position).getSend_nick());
        holder.rankingTop.setImageResource(id+position);
        x.image().bind(holder.rankingImage,data.get(position).getIcon_url());
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ranking_top)
        ImageView rankingTop;
        @BindView(R.id.ranking_image)
        ImageView rankingImage;
        @BindView(R.id.ranking_name)
        TextView rankingName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
