package com.qianfeng.manmankan.utils;

import android.content.Context;
import android.media.AudioManager;

/**
 * Created by 亚奇 on 2016/9/7.
 */
public class VolumeController {
    public static void volumeUp(Context context,float yDelta,int screenWidth){
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
//        获取当前音量
        int streamVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
//        获取当前音量
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        double add = 2.0 * yDelta * maxVolume / screenWidth;
        double changed = Math.min(streamVolume - add, maxVolume);
//        设置音量
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, (int) changed,AudioManager.FLAG_SHOW_UI);
    }
    public static void volumeDown(Context context,float yDelta,int screenWidth){
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        double sub = 0.5 * maxVolume * yDelta / screenWidth;
        double changed = Math.max(0, currentVolume - sub);
         audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, (int) changed,AudioManager.FLAG_SHOW_UI);
    }
}
