package com.qianfeng.manmankan;

import android.app.Application;
import android.graphics.Bitmap;

import com.squareup.picasso.Picasso;

import org.xutils.x;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class KanTVApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //xUtils初始化
        x.Ext.init(this);
        x.Ext.setDebug(true);
        //Picasso初始化
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.defaultBitmapConfig(Bitmap.Config.RGB_565)
                //显示加载标签
                .indicatorsEnabled(true)
                //Log
                .loggingEnabled(true);

        Picasso.setSingletonInstance(builder.build());
    }
}
