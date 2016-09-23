package com.qianfeng.manmankan.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.qianfeng.manmankan.R;

/**
 * Created by 亚奇 on 2016/9/23.
 */
public class RightFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mGroup;
    private RecyclerView mRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       layout=inflater.inflate(R.layout.right_fragment,container,false);
        return layout;
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

                break;
            case R.id.ranking_right:

                break;
        }
    }
}
