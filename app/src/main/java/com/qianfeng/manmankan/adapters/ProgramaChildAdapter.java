package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.model.programas.ProgramaChildModel;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/20.
 */
public class ProgramaChildAdapter extends RecyclerView.Adapter<ProgramaChildAdapter.ViewHolder> implements View.OnClickListener {

    private List<ProgramaChildModel.DataBean> data;
    private LayoutInflater inflater;
    private ImageOptions options;
    private ImageOptions options1;
    private OnClickItemListener listener;
    private RecyclerView mRecyclerView;

    public void setListener(OnClickItemListener listener) {
        this.listener = listener;
    }

    public ProgramaChildAdapter(Context context) {
        data = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        options=new ImageOptions.Builder().setCircular(true).build();
        options1=new ImageOptions.Builder().setLoadingDrawableId(R.mipmap.live_default).build();
    }

    public void updateRes(List<ProgramaChildModel.DataBean> list) {
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }
    public void addRes(List<ProgramaChildModel.DataBean> list) {
        data.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView=recyclerView;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.programa_child_item, parent, false);
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        x.image().bind(holder.showImg, data.get(position).getThumb(),options1);
        x.image().bind(holder.userPic, data.get(position).getAvatar(),options);

        String num = data.get(position).getView();
        double d = Double.parseDouble(num);
        if (d <10000) {
            holder.onLine.setText(num);
        }else{
            DecimalFormat format = new DecimalFormat("#0.0");
            String formatNum = format.format(d / 10000);
            holder.onLine.setText(formatNum+"w");
        }

        holder.user.setText(data.get(position).getNick());
        holder.contentName.setText(data.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);

        listener.onClick(v,position);
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.programa_child_showimg)
        ImageView showImg;
        @BindView(R.id.programa_child_onlinenum)
        TextView onLine;
        @BindView(R.id.programa_child_userpic)
        ImageView userPic;
        @BindView(R.id.programa_child_user)
        TextView user;
        @BindView(R.id.programa_child_comtentname)
        TextView contentName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
    public interface OnClickItemListener{
        void onClick(View view,int position);


    }



}
