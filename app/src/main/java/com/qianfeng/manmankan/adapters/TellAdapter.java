package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qianfeng.manmankan.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 亚奇 on 2016/9/23.
 */
public class TellAdapter extends RecyclerView.Adapter<TellAdapter.ViewHolder> {
    private LayoutInflater inflater;
   private List<String> data;

    public TellAdapter(Context context, List<String> data) {
        this.data = data;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.tell_left_item, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
           holder.tellItemName.setText("机器人"+position+"号  :  ");
        holder.tellItemName.setTextColor(Color.BLUE);
        holder.tellItemContent.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tell_item_name)
        TextView tellItemName;
        @BindView(R.id.tell_item_content)
        TextView tellItemContent;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
