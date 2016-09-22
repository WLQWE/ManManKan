package com.qianfeng.manmankan.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.qianfeng.manmankan.R;

/**
 * Created by SacuraQH on 2016/9/22.
 */
public class ErrorView extends LinearLayout{

    Button reloading;

    public ErrorView(Context context) {
        this(context, null);
    }

    public ErrorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.error_view, this);
        reloading= (Button)findViewById(R.id.reloading);
    }

    public void setButtonListener(OnClickListener listener) {
        reloading.setOnClickListener(listener);
    }

}