package com.qianfeng.manmankan.model;

import com.qianfeng.manmankan.model.programas.ProgramaChildModel;

import java.util.List;

/**
 * Created by SacuraQH on 2016/9/22.
 */
public class SearchModel {

    /**
     * code : 200
     * data : {"items":[{"category_name":"DNF","thumb":"http://snap.quanmin.tv/339369-1474547983-735.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/e96218b78fa5d937dcea92d9f64bc4ecpng?imageView2/2/w/300/","title":"爆头：稳健爆免费天空盒子罐子圆梦了！","is_shield":false,"nick":"全民跨二丶爆头","uid":339369,"view":"17043","category_id":10,"slug":"baotou","category_slug":"dnf","play_status":true},{"category_name":"炉石传说","thumb":"http://snap.quanmin.tv/3736719-1474547983-220.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/bac075590755ea3228ecf603793d3a61jpg?imageView2/2/w/300/","title":"梦梦开卡很倾城","is_shield":false,"nick":"猫小梦","uid":3736719,"view":"8530","category_id":3,"slug":"catdream","category_slug":"heartstone","play_status":true},{"category_name":"全民星秀","thumb":"http://snap.quanmin.tv/4115217-1474547944-125.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"总有一首歌温柔了你的心","is_shield":false,"nick":"席梦baby","uid":4115217,"view":"5144","category_id":4,"slug":"","category_slug":"beauty","play_status":true},{"category_name":"全民星秀","thumb":"http://snap.quanmin.tv/6285213-1474547988-613.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/62a7c6be626b9ead0e456d52383eb928?imageView2/2/w/300/","title":"新主播求关注*-*","is_shield":false,"nick":"卿卿茹梦","uid":6285213,"view":"5042","category_id":4,"slug":"","category_slug":"beauty","play_status":true},{"category_name":"网络游戏","thumb":"http://snap.quanmin.tv/3455094-1474547944-527.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/84e52df3f96895465ba203541a18eafbjpg?imageView2/2/w/300/","title":"Biu小克 梦三国 10vs10","is_shield":false,"nick":"Biu小克","uid":3455094,"view":"2389","category_id":11,"slug":"xiaoke3124","category_slug":"webgame","play_status":true},{"category_name":"QQ飞车","thumb":"http://snap.quanmin.tv/5555542-1474547987-960.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/d24086c735b2e261344b1f09aed1cad6?imageView2/2/w/300/","title":"梦辰：2根黄瓜上房管或边境1小时啊","is_shield":false,"nick":"Stars丶梦辰","uid":5555542,"view":"1167","category_id":30,"slug":"","category_slug":"qqfeiche","play_status":true},{"category_name":"暴雪经典","thumb":"http://snap.quanmin.tv/5825208-1474547989-1.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"梦璃浩劫DH的成长故事","is_shield":false,"nick":"梦璃梦璃梦","uid":5825208,"view":"99","category_id":8,"slug":"dreaml","category_slug":"blizzard","play_status":true},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/1344004-1474547944-33.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"三十年河东，三十年河西。莫欺少年穷","is_shield":false,"nick":"全民Tv丶梦小想","uid":1344004,"view":"88","category_id":1,"slug":"gxy","category_slug":"lol","play_status":true},{"category_name":"全民星秀","thumb":"http://snap.quanmin.tv/5999482-1474547984-651.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/352dc1fc481ef7e3affc45ffa643bab3jpg?imageView2/2/w/300/","title":"多娜哎梦的直播间","is_shield":false,"nick":"多娜哎梦","uid":5999482,"view":"87","category_id":4,"slug":"","category_slug":"beauty","play_status":true},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/844172-1474547943-860.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"暴力男枪 80暴击","is_shield":false,"nick":"全民快乐小梦","uid":844172,"view":"87","category_id":1,"slug":"","category_slug":"lol","play_status":true}],"total":490,"pageNb":49}
     */

    private int code;
    /**
     * items : [{"category_name":"DNF","thumb":"http://snap.quanmin.tv/339369-1474547983-735.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/e96218b78fa5d937dcea92d9f64bc4ecpng?imageView2/2/w/300/","title":"爆头：稳健爆免费天空盒子罐子圆梦了！","is_shield":false,"nick":"全民跨二丶爆头","uid":339369,"view":"17043","category_id":10,"slug":"baotou","category_slug":"dnf","play_status":true},{"category_name":"炉石传说","thumb":"http://snap.quanmin.tv/3736719-1474547983-220.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/bac075590755ea3228ecf603793d3a61jpg?imageView2/2/w/300/","title":"梦梦开卡很倾城","is_shield":false,"nick":"猫小梦","uid":3736719,"view":"8530","category_id":3,"slug":"catdream","category_slug":"heartstone","play_status":true},{"category_name":"全民星秀","thumb":"http://snap.quanmin.tv/4115217-1474547944-125.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"总有一首歌温柔了你的心","is_shield":false,"nick":"席梦baby","uid":4115217,"view":"5144","category_id":4,"slug":"","category_slug":"beauty","play_status":true},{"category_name":"全民星秀","thumb":"http://snap.quanmin.tv/6285213-1474547988-613.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/62a7c6be626b9ead0e456d52383eb928?imageView2/2/w/300/","title":"新主播求关注*-*","is_shield":false,"nick":"卿卿茹梦","uid":6285213,"view":"5042","category_id":4,"slug":"","category_slug":"beauty","play_status":true},{"category_name":"网络游戏","thumb":"http://snap.quanmin.tv/3455094-1474547944-527.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/84e52df3f96895465ba203541a18eafbjpg?imageView2/2/w/300/","title":"Biu小克 梦三国 10vs10","is_shield":false,"nick":"Biu小克","uid":3455094,"view":"2389","category_id":11,"slug":"xiaoke3124","category_slug":"webgame","play_status":true},{"category_name":"QQ飞车","thumb":"http://snap.quanmin.tv/5555542-1474547987-960.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/d24086c735b2e261344b1f09aed1cad6?imageView2/2/w/300/","title":"梦辰：2根黄瓜上房管或边境1小时啊","is_shield":false,"nick":"Stars丶梦辰","uid":5555542,"view":"1167","category_id":30,"slug":"","category_slug":"qqfeiche","play_status":true},{"category_name":"暴雪经典","thumb":"http://snap.quanmin.tv/5825208-1474547989-1.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"梦璃浩劫DH的成长故事","is_shield":false,"nick":"梦璃梦璃梦","uid":5825208,"view":"99","category_id":8,"slug":"dreaml","category_slug":"blizzard","play_status":true},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/1344004-1474547944-33.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"三十年河东，三十年河西。莫欺少年穷","is_shield":false,"nick":"全民Tv丶梦小想","uid":1344004,"view":"88","category_id":1,"slug":"gxy","category_slug":"lol","play_status":true},{"category_name":"全民星秀","thumb":"http://snap.quanmin.tv/5999482-1474547984-651.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/352dc1fc481ef7e3affc45ffa643bab3jpg?imageView2/2/w/300/","title":"多娜哎梦的直播间","is_shield":false,"nick":"多娜哎梦","uid":5999482,"view":"87","category_id":4,"slug":"","category_slug":"beauty","play_status":true},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/844172-1474547943-860.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"暴力男枪 80暴击","is_shield":false,"nick":"全民快乐小梦","uid":844172,"view":"87","category_id":1,"slug":"","category_slug":"lol","play_status":true}]
     * total : 490
     * pageNb : 49
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int total;
        private int pageNb;
        private List<ProgramaChildModel.DataBean> items;

        public List<ProgramaChildModel.DataBean> getItem() {
            return items;
        }

        public void setItem(List<ProgramaChildModel.DataBean> items) {
            this.items = items;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNb() {
            return pageNb;
        }

        public void setPageNb(int pageNb) {
            this.pageNb = pageNb;
        }
    }
}
