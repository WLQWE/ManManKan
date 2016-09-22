package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.model.mines.Info;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/22.
 */
public class MineItemAdapter extends BaseAdapter {
    private List<Info> data;
    private LayoutInflater inflater;

    public MineItemAdapter(Context context) {
        data=new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void updateRes(List<Info> list) {
        data.addAll(list);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Info getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolders holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.mine_item, parent, false);
            holder=new ViewHolders(convertView);
            convertView.setTag(holder);

        }else{
            holder= (ViewHolders) convertView.getTag();
        }
        holder.mItemName.setText(data.get(position).getName());
        holder.mItemImg.setImageResource(data.get(position).getImg());


        return convertView;
    }



    public class ViewHolder {
        TextView itemName;
        ImageView itemImg;
    }

    static class ViewHolders {
        @BindView(R.id.mine_item_img)
        ImageView mItemImg;
        @BindView(R.id.mine_item_name)
        TextView mItemName;

        ViewHolders(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
