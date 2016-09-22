package com.qianfeng.manmankan.utils;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.Toast;

/**
 *亮度需要添加权限 : WRITE_SETTINGS
 */
public class LightController {

    public static void lightUp(Activity context, float yDelta, int screenWidth){
try {
    // 我们要获取当前的亮度
    int currentLight = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, -1);
//    系统亮度不提供最大值 0 - 255
    float add = 1.5f * yDelta * 255 / screenWidth;
    float min = Math.min(255, currentLight - add);
//        改变界面亮度
    WindowManager.LayoutParams attributes = context.getWindow().getAttributes();
//        screenBrightness 取值 0-1 float;
    float changed = min / 255;
    attributes.screenBrightness= changed;
    context.getWindow().setAttributes(attributes);
    Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS, (int) Math.min(255,currentLight-yDelta));
}catch (Exception e){

}
    }
    public static void lightDown(Activity context, float yDelta, int screenWidth){
         try {
             // 我们要获取当前的亮度
             int currentLight = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, -1);
//    系统亮度不提供最大值 0 - 255
             float add = 1.5f * yDelta * 255 / screenWidth;
             float max = Math.max(0, currentLight - add);
//        改变界面亮度
             WindowManager.LayoutParams attributes = context.getWindow().getAttributes();
//        screenBrightness 取值 0-1 float;
             float changed = max / 255;
             attributes.screenBrightness= changed;
             context.getWindow().setAttributes(attributes);
             Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS, (int) Math.max(0,currentLight-yDelta));
         }catch (Exception e){
             Toast.makeText(context,"无法改变亮度",Toast.LENGTH_SHORT).show();
         }
    }
}
