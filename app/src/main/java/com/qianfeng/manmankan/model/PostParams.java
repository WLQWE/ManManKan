package com.qianfeng.manmankan.model;

/**
 * Created by SacuraQH on 2016/9/22.
 */
public class PostParams {

    @Override
    public String toString() {
        return "PostParams{" +
                "device='" + device + '\'' +
                ", v='" + v + '\'' +
                ", screen='" + screen + '\'' +
                ", ch='" + ch + '\'' +
                ", sh=" + sh +
                ", p=" + p +
                ", sw=" + sw +
                ", uid='" + uid + '\'' +
                ", net='" + net + '\'' +
                ", ver='" + ver + '\'' +
                ", os='" + os + '\'' +
                '}';
    }

    /**
     * device : 862973033141263
     * v : 2.1.3
     * screen : 2
     * ch : 360zhushou
     * sh : 1280
     * p : {"size":10,"key":"梦","page":0,"categoryId":0}
     * sw : 720
     * uid : 19b8a4db7d43
     * net : 0
     * ver : 4
     * os : 1
     */

    private String device;
    private String v;
    private String screen;
    private String ch;
    private int sh;
    /**
     * size : 10
     * key : 梦
     * page : 0
     * categoryId : 0
     */

    private PBean p;
    private int sw;
    private String uid;
    private String net;
    private String ver;
    private String os;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public int getSh() {
        return sh;
    }

    public void setSh(int sh) {
        this.sh = sh;
    }

    public PBean getP() {
        return p;
    }

    public void setP(PBean p) {
        this.p = p;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public static class PBean {
        private int size;
        private String key;
        private int page;
        private int categoryId;

        @Override
        public String toString() {
            return "PBean{" +
                    "size=" + size +
                    ", key='" + key + '\'' +
                    ", page=" + page +
                    ", categoryId=" + categoryId +
                    '}';
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }
    }
}
