package com.qianfeng.manmankan.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.adapters.TellAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 亚奇 on 2016/9/23.
 */
public class LeftFragment extends BaseFragment implements Handler.Callback{
    private RecyclerView mRecycler;
    private Handler mHandler=new Handler(this);
    private  LinearLayoutManager layoutManager;
    private  List<String> data;
    private   int firstVisibleItemPosition;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       layout=inflater.inflate(R.layout.left_fragment,container,false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mRecycler = (RecyclerView) layout.findViewById(R.id.tell_recycler);
        data=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add("我一个达不溜");
            data.add("猿计划：撸鱼");
            data.add("致命碘盐");
            data.add("你竟然敢瞅我");
            data.add("救命啊，杀淫啦");
            data.add("快来淫儿救我");
            data.add("66666666666");
            data.add("因吹思婷");
            data.add("笋干爆炸");
            data.add("自己人，憋开腔");
            data.add("喂，幺幺零吗");
        }
       layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setSmoothScrollbarEnabled(true);
        mRecycler.setLayoutManager(layoutManager);
        TellAdapter adapter = new TellAdapter(getContext(), data);
        mRecycler.setAdapter(adapter);

        mHandler.sendEmptyMessageDelayed(100,1000);
    }

    @Override
    public boolean handleMessage(Message msg) {
        Log.e("erer", "handleMessage: ");
        firstVisibleItemPosition= layoutManager.findFirstVisibleItemPosition();
        gotopage();
mHandler.sendEmptyMessageDelayed(100,1000);
        return false;
    }
    public void gotopage(){

        int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        Log.e("erer", "handleMessage: "+firstVisibleItemPosition+"   "+lastVisibleItemPosition);
        firstVisibleItemPosition++;
       layoutManager.scrollToPosition(lastVisibleItemPosition+1);
//        layoutManager.scrollToPosition(5);
        if (lastVisibleItemPosition<data.size()-1){

        }else {
            layoutManager.scrollToPosition(1);
        }
    }
}
