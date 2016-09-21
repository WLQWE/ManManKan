package com.qianfeng.manmankan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.constans.HttpConstants;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class ProgramaThird extends AppCompatActivity {
    public static final String TAG = ProgramaThird.class.getSimpleName();
    @BindView(R.id.programa_third_videoview)
    VideoView mVideoView;
    static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa_third);
        ButterKnife.bind(this);
        initView();
        setupView();
    }

    private void setupView() {
        Intent intent = getIntent();
        String uid = intent.getStringExtra("uid");
        Date date = new Date();
        CharSequence format = DateFormat.format("MMddhhmm", date);
        String path = HttpConstants.RECOMMEND_VIEWPAGER_START + uid + HttpConstants.RECOMMEND_VIEWPAGER_MIDDLE +format+ HttpConstants.RECOMMEND_VIEWPAGER_END;
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {
                Log.e(TAG,"onSuccess");
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject ws = jsonObject.getJSONObject("ws");
                    JSONObject hls = ws.getJSONObject("hls");
                    JSONObject object = hls.getJSONObject("3");
                    url = object.opt("src").toString();
                    Log.e(TAG,url);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                Log.e(TAG,"onFinished");
            }
        });


    }

    private void initView() {
        mVideoView.setVideoPath("http://hls.quanmin.tv/live/376501_L3/playlist.m3u8");
        mVideoView.setMediaController(new MediaController(ProgramaThird.this));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);
            }
        });
        mVideoView.start();
    }
}
