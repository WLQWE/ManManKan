package com.qianfeng.manmankan.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.adapters.PlayerViewPagerAdapter;
import com.qianfeng.manmankan.constans.HttpConstants;
import com.qianfeng.manmankan.events.EventModel;
import com.qianfeng.manmankan.model.playermodels.PlayerModel;
import com.qianfeng.manmankan.ui.fragments.LeftFragment;
import com.qianfeng.manmankan.ui.fragments.RightFragment;
import com.qianfeng.manmankan.utils.LightController;
import com.qianfeng.manmankan.utils.MyShare;
import com.qianfeng.manmankan.utils.VolumeController;

import org.greenrobot.eventbus.EventBus;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class PlayerActivity extends BaseActivity implements View.OnTouchListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

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
    @BindView(R.id.player_vertical_controller_left)
    LinearLayout mControllerLeft;
    @BindView(R.id.full_top_exit)
    Button mFullTopExit;
    @BindView(R.id.btn_screen_gift)
    Button mScreenGift;
    @BindView(R.id.btn_screen_definition)
    Button mScreenDefinition;
    @BindView(R.id.btn_full_shared)
    Button mFullShared;
    @BindView(R.id.btn_live_exit)
    Button btnLiveExit;
    @BindView(R.id.full_bottom_refresh)
    Button mFullBottomRefresh;
    @BindView(R.id.full_hot_text)
    Button mFullHotText;
    @BindView(R.id.full_send_text)
    Button mFullSendText;
    @BindView(R.id.full_gift)
    Button mFullGift;
    @BindView(R.id.definition_list)
    ListView mDefinitionList;
    @BindView(R.id.full_title_text)
    TextView mFullTitleText;
    @BindView(R.id.btn_full_follow)
    CheckBox mBtnFullFollow;
    @BindView(R.id.live_people)
    TextView mLivePeople;
    @BindView(R.id.full_bottom_pause)
    CheckBox mFullBottomPause;
    @BindView(R.id.full_edit_text)
    EditText mFullEditText;
    @BindView(R.id.full_toolbar_dan)
    CheckBox mFullToolbarDan;
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
    private boolean isFull;
    private int oldHeight;
    private boolean screenGift;
    private PopupWindow popupWindow;

    private Button mReport;
    private Button mPopShare;
    private String uid;
    private DateFormat format;
    private PlayerViewPagerAdapter adapter;
    private ImageOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplication());
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        options = new ImageOptions.Builder().setCircular(true).build();
        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");
        format = new SimpleDateFormat("MMddHHmm");
        mVideo.setOnTouchListener(this);
        mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        mGift.setOnCheckedChangeListener(this);
        mOnOff.setOnCheckedChangeListener(this);
        mRoomFollowBtn.setOnCheckedChangeListener(this);
        mRoomRemindBtn.setOnCheckedChangeListener(this);
        String[] tabdata = {"聊天", "排行"};
        mRoomTab.addTab(mRoomTab.newTab().setText(tabdata[0]));
        mRoomTab.addTab(mRoomTab.newTab().setText(tabdata[1]));

        List<Fragment> data = new ArrayList<>();
        data.add(new LeftFragment());
        data.add(new RightFragment());
        adapter = new PlayerViewPagerAdapter(getSupportFragmentManager(), data, tabdata);
        mRoomViewpager.setAdapter(adapter);
        mRoomTab.setupWithViewPager(mRoomViewpager);
        getData();
    }

    private void getData() {
        Date date = new Date();
        String time = format.format(date);
        RequestParams params = new RequestParams(HttpConstants.RECOMMEND_VIEWPAGER_START + uid + HttpConstants.RECOMMEND_VIEWPAGER_MIDDLE + time + HttpConstants.RECOMMEND_VIEWPAGER_END);
        x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {
                if (result == null) {
                    Log.e(TAG, "onSuccess: " + "result-------空");
                }
                Gson gson = new Gson();
                PlayerModel playerModel = gson.fromJson(result, PlayerModel.class);
                EventModel eventModel = new EventModel();
                eventModel.setData(playerModel.getRank_total());
                eventModel.setDataTwo(playerModel.getRank_week());
                EventBus.getDefault().post(eventModel);
                String src = playerModel.getRoom_lines().get(0).getHls().getThree().getSrc();

                mRoomName.setText(playerModel.getNick());
                mRoomContent.setText(playerModel.getIntro());
                x.image().bind(mRoomIcon, playerModel.getAvatar(), options);
                mVideo.setVideoPath(src);
                mVideo.start();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

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
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
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
                    } else {
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
            mControllerLeft.setVisibility(View.GONE);
//            Animation animation = AnimationUtils.loadAnimation(this, R.anim.vertical_control_exit);
//            mControl.startAnimation(animation);
//            mControllerLeft.startAnimation(animation);
        } else if (mControl.getVisibility() == View.GONE) {
            mControl.setVisibility(View.VISIBLE);
            mControllerLeft.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.vertical_control);
            mControl.startAnimation(animation);
            mControllerLeft.startAnimation(animation);
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.video_on_off:
                if (isChecked) {
                    mVideo.pause();
                } else {
                    mVideo.start();
                }

                break;
            case R.id.video_gift:

                break;
            case R.id.room_follow_btn:
                if (isChecked) {
                    mRoomFollowText.setText("已关注");
                } else {
                    mRoomRemindBtn.setChecked(false);
                    mRoomFollowText.setText("关注");
                }
                break;
            case R.id.room_remind_btn:
                if (isChecked) {
                    TranslateAnimation right = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF,
                            0, TranslateAnimation.RELATIVE_TO_SELF, 1
                            , TranslateAnimation.RELATIVE_TO_SELF, 0, TranslateAnimation.RELATIVE_TO_SELF, 0);
                    right.setDuration(100);
                    right.setFillAfter(true);
                    mRoomRemindCircle.startAnimation(right);
                    mRoomFollowBtn.setChecked(true);
                } else {
                    TranslateAnimation left = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF,
                            1, TranslateAnimation.RELATIVE_TO_SELF, 0
                            , TranslateAnimation.RELATIVE_TO_SELF, 0, TranslateAnimation.RELATIVE_TO_SELF, 0);
                    left.setDuration(100);
                    left.setFillAfter(true);
                    mRoomRemindCircle.startAnimation(left);
                }
                break;
        }
    }

    private void exitFull() {
        horizontalShowOrHideController();
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ViewGroup.LayoutParams params = mVideo.getLayoutParams();
        params.height = oldHeight;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mVideo.setLayoutParams(params);
        isFull = false;
        isLandscape = false;
        mPlayerBottom.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isFull) {
                exitFull();
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.full_top_exit, R.id.btn_screen_gift, R.id.btn_screen_definition, R.id.btn_full_shared, R.id.btn_live_exit, R.id.video_more_btn, R.id.video_full_screen, R.id.full_bottom_refresh, R.id.full_hot_text, R.id.full_send_text, R.id.full_gift})
    public void onClick(View view) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        switch (view.getId()) {
            case R.id.full_top_exit:
                exitFull();
                break;
            case R.id.btn_screen_gift:
                if (screenGift) {
                    mScreenGift.setText("屏蔽礼物");
                    Toast.makeText(this, "礼物特效已开启", Toast.LENGTH_SHORT).show();
                    screenGift = false;
                } else {
                    mScreenGift.setText("开启礼物");
                    Toast.makeText(this, "礼物特效已屏蔽", Toast.LENGTH_SHORT).show();
                    screenGift = true;
                }
                break;
            case R.id.btn_screen_definition:
                mDefinitionList.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_full_shared:
                MyShare.showShare();
                break;
            case R.id.btn_live_exit:
                finish();
                break;
            case R.id.video_more_btn:

                if (popupWindow == null) {
                    View pop = LayoutInflater.from(this).inflate(R.layout.popupwindow_more, null);
                    mReport = (Button) pop.findViewById(R.id.pop_report);
                    mPopShare = (Button) pop.findViewById(R.id.pop_share);
                    mReport.setOnClickListener(this);
                    mPopShare.setOnClickListener(this);
                    popupWindow = new PopupWindow(pop);
                    popupWindow.setWidth(widthPixels / 5);
                    popupWindow.setHeight(heightPixels / 9);

                }
                if (popupWindow.isShowing()) {
                    // 如果显示状态 就隐藏
                    popupWindow.dismiss();
                } else {
//            popupWindow.showAsDropDown(view,widthPixels / 6,0);
                    popupWindow.showAtLocation(view, Gravity.RIGHT | Gravity.TOP, 50, 60);
                }

                break;
            case R.id.video_full_screen:
                mPlayerBottom.setVisibility(View.GONE);
                mControllerLeft.setVisibility(View.GONE);
                mControl.setVisibility(View.GONE);
                mFullTopControl.setVisibility(View.VISIBLE);
                mFullBottomControl.setVisibility(View.VISIBLE);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                旋转屏幕
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                ViewGroup.LayoutParams layoutParams = mVideo.getLayoutParams();
                oldHeight = layoutParams.height;
                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams.width = mScreenHeight;
                mVideo.setLayoutParams(layoutParams);
                isLandscape = true;
                isFull = true;
                break;
            case R.id.full_bottom_refresh:
                Toast.makeText(this, "刷新", Toast.LENGTH_SHORT);
                break;
            case R.id.full_hot_text:

                break;
            case R.id.full_send_text:

                break;
            case R.id.full_gift:

                break;
            case R.id.pop_report:
                Toast.makeText(this, "已举报", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pop_share:
                Toast.makeText(this, "已分享", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
