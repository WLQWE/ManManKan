package com.qianfeng.manmankan.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.adapters.RankingAdapter;
import com.qianfeng.manmankan.events.EventModel;
import com.qianfeng.manmankan.model.playermodels.PlayerModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by 亚奇 on 2016/9/23.
 */
public class RightFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {
    private static final String TAG =RightFragment.class.getSimpleName() ;
    private RadioGroup mGroup;
    private RecyclerView mRecycler;
    private List<PlayerModel.RankTotalBean> data;
    private List<PlayerModel.RankTotalBean> dataTwo;
    private RankingAdapter rankingAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       layout=inflater.inflate(R.layout.right_fragment,container,false);
        EventBus.getDefault().register(this);

        return layout;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }


    private void initView() {
        mGroup = (RadioGroup) layout.findViewById(R.id.ranking_group_btn);
        mGroup.setOnCheckedChangeListener(this);
        mRecycler = (RecyclerView) layout.findViewById(R.id.ranking_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecycler.setLayoutManager(layoutManager);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.ranking_left:

                if (data!=null) {
                    Log.e(TAG, "onCheckedChanged: "+data.size() );
                    rankingAdapter.updateRes(data);
                }
                break;
            case R.id.ranking_right:
                  rankingAdapter.updateRes(dataTwo);
                Log.e(TAG, "onCheckedChanged: "+dataTwo.size() );
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Subscribe
    public void onEvent(EventModel eventModel){
        data = eventModel.getData();
        dataTwo = eventModel.getDataTwo();
        Log.e(TAG, "initView: " +data.size()+"   "+dataTwo.size());

        rankingAdapter = new RankingAdapter(getContext(),data);
        mRecycler.setAdapter(rankingAdapter);
    }
}
