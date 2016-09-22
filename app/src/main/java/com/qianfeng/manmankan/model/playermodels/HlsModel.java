package com.qianfeng.manmankan.model.playermodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 亚奇 on 2016/9/22.
 */
public class HlsModel {
    @SerializedName("3")
    private ThreeModel three;
    @SerializedName("4")
    private ThreeModel four;
    @SerializedName("5")
    private ThreeModel five;

    public ThreeModel getThree() {
        return three;
    }

    public void setThree(ThreeModel three) {
        this.three = three;
    }

    public ThreeModel getFour() {
        return four;
    }

    public void setFour(ThreeModel four) {
        this.four = four;
    }

    public ThreeModel getFive() {
        return five;
    }

    public void setFive(ThreeModel five) {
        this.five = five;
    }
}
