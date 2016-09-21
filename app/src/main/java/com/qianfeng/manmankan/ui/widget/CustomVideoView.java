package com.qianfeng.manmankan.ui.widget;

import android.content.Context;
import android.util.AttributeSet;

import io.vov.vitamio.widget.VideoView;


/**
 * Created by 亚奇 on 2016/9/7.
 */
public class CustomVideoView extends VideoView {
    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width,height);
    }

    @Override
    public void setVideoLayout(int layout, float aspectRatio) {
        super.setVideoLayout(layout, aspectRatio);
        getHolder().setFixedSize(this.getWidth(),this.getHeight());
    }

}
