package com.qianfeng.manmankan.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.utils.LightController;
import com.qianfeng.manmankan.utils.VolumeController;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class PlayerActivity extends BaseActivity implements View.OnTouchListener, CompoundButton.OnCheckedChangeListener {

    private static final String TAG = PlayerActivity.class.getSimpleName();
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
    @BindView(R.id.player_vertical_controller)
    LinearLayout mControl;
    @BindView(R.id.player_bottom)
    LinearLayout mPlayerBottom;
    @BindView(R.id.full_bottom_control)
    LinearLayout mFullBottomControl;
    @BindView(R.id.full_top_control)
    LinearLayout mFullTopControl;
    private int mScreenHeight;
    private int mScreenWidth;
    //    刚按下时的位置
    private float mStartX;
    private float mStartY;
    //    最近一次的位置
    private float mLastX;
    private float mLastY;
    private boolean isLandscape;
    private float threshold = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplication());
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        mVideo.setVideoPath("http://flv.quanmin.tv/live/13333_L3.flv");
        mVideo.start();
        mVideo.setOnTouchListener(this);
        mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        mGift.setOnCheckedChangeListener(this);
        mOnOff.setOnCheckedChangeListener(this);
        mRoomFollowBtn.setOnCheckedChangeListener(this);
        mRoomRemindBtn.setOnCheckedChangeListener(this);

        getData();
    }

    private void getData() {
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = x;
                mStartY = y;
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isLandscape) {
                    float xDelta = x - mLastX;
                    float yDetla = y - mLastY;
                    if (Math.abs(yDetla) > threshold) {
                        if (x > mScreenHeight / 2) {
//                            改变声音
                            if (yDetla > 0) {
//                                音量减
                                Log.e(TAG, "onTouch: ------音量减");
                                VolumeController.volumeDown(this, yDetla, mScreenWidth);
                            } else {
//                                音量加
                                Log.e(TAG, "onTouch:  ------音量加");
                                VolumeController.volumeUp(this, yDetla, mScreenWidth);
                            }
                        } else {
//                            改变亮度
                            if (yDetla > 0) {
//                                亮度减
                                Log.e(TAG, "onTouch: ------亮度减");
                                LightController.lightDown(PlayerActivity.this, yDetla, mScreenWidth);
                            } else {
//                                亮度加
                                Log.e(TAG, "onTouch:  ------亮度加");
                                LightController.lightUp(PlayerActivity.this, yDetla, mScreenWidth);
                            }
                        }
                    }

                }

                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:

                    if (Math.abs(x - mStartX) < threshold && Math.abs(y - mStartY) < threshold) {
                        if (!isLandscape) {
                            showOrHideController();
                        }else {
                            horizontalShowOrHideController();
                        }
                    }

                break;
        }
        return true;
    }

    private void horizontalShowOrHideController() {
        if (mFullTopControl.getVisibility() == View.VISIBLE) {
            mFullTopControl.setVisibility(View.GONE);
            mFullBottomControl.setVisibility(View.GONE);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.controller_exit);
            Animation animationTop = AnimationUtils.loadAnimation(this, R.anim.top_control_exit);
            mFullBottomControl.startAnimation(animation);
            mFullTopControl.startAnimation(animationTop);
        } else if (mFullTopControl.getVisibility() == View.GONE) {
            mFullTopControl.setVisibility(View.VISIBLE);
            mFullBottomControl.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.controller);
            Animation animationTop = AnimationUtils.loadAnimation(this, R.anim.top_control);
            mFullBottomControl.startAnimation(animation);
            mFullTopControl.startAnimation(animationTop);

        }
    }
    private void showOrHideController() {
        if (mControl.getVisibility() == View.VISIBLE) {
            mControl.setVisibility(View.GONE);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.vertical_control_exit);
            mControl.startAnimation(animation);
        } else if (mControl.getVisibility() == View.GONE) {
            mControl.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.vertical_control);
            mControl.startAnimation(animation);
        }
    }


    @OnClick({R.id.video_more_btn, R.id.video_full_screen})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.video_more_btn:

                break;
            case R.id.video_full_screen:
                mPlayerBottom.setVisibility(View.GONE);
                mControl.setVisibility(View.GONE);
                mFullTopControl.setVisibility(View.VISIBLE);
                mFullBottomControl.setVisibility(View.VISIBLE);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                旋转屏幕
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                ViewGroup.LayoutParams layoutParams = mVideo.getLayoutParams();

                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams.width = mScreenHeight;
                mVideo.setLayoutParams(layoutParams);
                isLandscape = true;
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.video_on_off:

                break;
            case R.id.video_gift:

                break;
            case R.id.room_follow_btn:
                if (isChecked) {
                    mRoomFollowText.setText("已关注");
                } else {
                    mRoomFollowText.setText("关注");
                }
                break;
            case R.id.room_remind_btn:
                if (isChecked) {

                    TranslateAnimation right = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF,
                            0, TranslateAnimation.RELATIVE_TO_SELF, 1
                            , TranslateAnimation.RELATIVE_TO_SELF, 0, TranslateAnimation.RELATIVE_TO_SELF
                            , 0);
                    right.setDuration(100);
                    right.setFillAfter(true);
                    mRoomRemindCircle.startAnimation(right);
                    mRoomFollowBtn.setChecked(true);
                } else {
                    TranslateAnimation left = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF,
                            1, TranslateAnimation.RELATIVE_TO_SELF, 0
                            , TranslateAnimation.RELATIVE_TO_SELF, 0, TranslateAnimation.RELATIVE_TO_SELF
                            , 0);
                    left.setDuration(100);
                    left.setFillAfter(true);
                    mRoomRemindCircle.startAnimation(left);
                }
                break;
        }
    }
}
