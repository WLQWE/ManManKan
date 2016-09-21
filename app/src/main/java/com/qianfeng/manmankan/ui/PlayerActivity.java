package com.qianfeng.manmankan.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.qianfeng.manmankan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class PlayerActivity extends BaseActivity {

    @BindView(R.id.player_video)
    VideoView mVideo;
    @BindView(R.id.video_more_btn)
    Button mMoreBtn;
    @BindView(R.id.video_gift)
    CheckBox mGift;
    @BindView(R.id.video_on_off)
    CheckBox mOnOff;
    @BindView(R.id.video_full_screen)
    Button mFullScreen;
    @BindView(R.id.room_icon)
    ImageView mRoomIcon;
    @BindView(R.id.room_name)
    TextView mRoomName;
    @BindView(R.id.room_content)
    TextView mRoomContent;
    @BindView(R.id.room_follow_btn)
    CheckBox mRoomFollowBtn;
    @BindView(R.id.room_follow_text)
    TextView mRoomFollowText;
    @BindView(R.id.room_remind_btn)
    CheckBox mRoomRemindBtn;
    @BindView(R.id.room_remind_circle)
    ImageView mRoomRemindCircle;
    @BindView(R.id.room_tab)
    TabLayout mRoomTab;
    @BindView(R.id.room_viewpager)
    ViewPager mRoomViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplication());
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);
        mVideo.setVideoPath("http://flv.quanmin.tv/live/1743331_L3.flv");
        mVideo.start();

        getData();
    }

    private void getData() {
    }
}
