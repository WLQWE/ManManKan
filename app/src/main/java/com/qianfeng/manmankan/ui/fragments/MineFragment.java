package com.qianfeng.manmankan.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.adapters.MineItemAdapter;
import com.qianfeng.manmankan.model.mines.Info;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class MineFragment extends BaseFragment {

    public static final String TAG = MineFragment.class.getSimpleName();
    @BindView(R.id.mine_talk)
    ImageView mTalk;
    @BindView(R.id.mine_set)
    ImageView mSet;
    @BindView(R.id.mine_userpic)
    ImageView userPic;
    @BindView(R.id.mine_llistview)
    ListView mLlistview;
    private MineItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.mine_fragment, container, false);

        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        List<Info> data=new ArrayList<>();
        Info info1 = new Info();
        info1.setImg(R.mipmap.ic_profile_host_room);
        info1.setName("房间管理");
        Info info2 = new Info();
        info2.setImg(R.mipmap.ic_profile_concern);
        info2.setName("我的关注");
        Info info3 = new Info();
        info3.setImg(R.mipmap.ic_profile_histoy);
        info3.setName("观看历史");
        Info info4 = new Info();
        info4.setImg(R.mipmap.icon_profile_remind);
        info4.setName("开播提醒");
        Info info5 = new Info();
        info5.setImg(R.mipmap.ic_profile_task);
        info5.setName("种子任务");
        Info info6 = new Info();
        info6.setImg(R.mipmap.ic_profile_game);
        info6.setName("游戏中心");
        data.add(info1);
        data.add(info2);
        data.add(info3);
        data.add(info4);
        data.add(info5);
        data.add(info6);
        adapter = new MineItemAdapter(getContext());
        adapter.updateRes(data);
        mLlistview.setAdapter(adapter);


    }
}
