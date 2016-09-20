package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.manmankan.model.programas.ProgramaChildModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class ProgramaChildAdapter extends RecyclerView.Adapter<ProgramaChildAdapter.ViewHolder>{
    private List<ProgramaChildModel.DataBean>data;
    private LayoutInflater inflater;
    public ProgramaChildAdapter(Context context) {
        data=new ArrayList<>();
        inflater=LayoutInflater.from(context);
    }
    public void updateRes(List<ProgramaChildModel.DataBean>data){

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
