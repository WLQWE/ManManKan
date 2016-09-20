package com.qianfeng.manmankan.constans;

/**
 * Created by 亚奇 on 2016/9/20.
 */
public class HttpConstants {
//    三个首页接口
    public static final String  RECOMMEND_HEADER="http://www.quanmin.tv/json/page/app-data/info.json?device=869953020997409&v=2.1.3&screen=2&ch=wandoujia&sh=1812&sw=1080&uid=WTKDU16629006724&net=0&ver=4&os=1";
    public static final String  RECOMMEND="http://www.quanmin.tv/json/page/appv2-index/info.json?09201152&device=869953020997409&v=2.1.3&screen=2&ch=wandoujia&sh=1812&sw=1080&uid=WTKDU16629006724&net=0&ver=4&os=1";
    public static final String PROGRAMA="http://www.quanmin.tv/json/categories/list.json?09201104&device=869953020997409&v=2.1.3&screen=2&ch=wandoujia&sh=1812&sw=1080&uid=WTKDU16629006724&net=0&ver=4&os=1";
    public static final String LIVE_START="http://www.quanmin.tv/json/play/list";
//    拼接 "_数字" 默认为空的
    public static final String LIVE_END=".json?09201103&device=869953020997409&v=2.1.3&screen=2&ch=wandoujia&sh=1812&sw=1080&uid=WTKDU16629006724&net=0&ver=4&os=1";

    //   推荐圆形分类图片内容接口  拼接方式: START+ "classification" + MIDDLE+ 当前时间 月 日 时 分 8位 +END
    public static final String RECOMMEND_SCROLL_START="http://www.quanmin.tv/json/categories/";
    public static final String RECOMMEND_SCROLL_MIDDLE="/list.json?";
    public static final String RECOMMEND_SCROLL_END="&device=869953020997409&v=2.1.3&screen=2&ch=wandoujia&sh=1812&sw=1080&uid=WTKDU16629006724&net=0&ver=4&os=1";

//    播放界面接口   拼接方式: START+ "fk" + MIDDLE+ 当前时间 月 日 时 分 8位 +END
    public static final String RECOMMEND_VIEWPAGER_START="http://www.quanmin.tv/json/rooms/";
    public static final String RECOMMEND_VIEWPAGER_MIDDLE="/info.json?";
    public static final String RECOMMEND_VIEWPAGER_END="&device=869953020997409&v=2.1.3&screen=2&ch=wandoujia&sh=1812&sw=1080&uid=WTKDU16629006724&net=0&ver=4&os=1";



}
