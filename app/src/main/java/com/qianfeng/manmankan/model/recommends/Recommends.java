package com.qianfeng.manmankan.model.recommends;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class Recommends {

    @SerializedName("app-index")
    private List<Index> indexs;

    @SerializedName("app-classification")
    private List<Classification> classifications;

    @SerializedName("app-recommendation")
    private List<Recommendation> recommendations;

    @SerializedName("app-lol")
    private List<Recommendation> lols;

    @SerializedName("app-beauty")
    private List<Recommendation> beautys;

    @SerializedName("app-heartstone")
    private List<Recommendation> heartstones;

    @SerializedName("app-huwai")
    private List<Recommendation> huwais;

    @SerializedName("app-overwatch")
    private List<Recommendation> overwatchs;

    @SerializedName("app-blizzard")
    private List<Recommendation> blizzards;

    @SerializedName("app-sport")
    private List<Recommendation> sports;

    @SerializedName("app-qqfeiche")
    private List<Recommendation> qqfeiches;

    @SerializedName("app-mobilegame")
    private List<Recommendation> mobilegames;

    @SerializedName("app-wangzhe")
    private List<Recommendation> wangzhes;

    @SerializedName("app-dota2")
    private List<Recommendation> dota2s;

    @SerializedName("app-tvgame")
    private List<Recommendation> tvgames;

    @SerializedName("app-webgame")
    private List<Recommendation> webgames;

    @SerializedName("app-dnf")
    private List<Recommendation> dnfs;

    @SerializedName("app-minecraft")
    private List<Recommendation> minecrafts;

    @SerializedName("app-list")
    private List<Lists> lists;

    public List<Index> getIndexs() {
        return indexs;
    }

    public void setIndexs(List<Index> indexs) {
        this.indexs = indexs;
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public List<Recommendation> getLols() {
        return lols;
    }

    public void setLols(List<Recommendation> lols) {
        this.lols = lols;
    }

    public List<Recommendation> getBeautys() {
        return beautys;
    }

    public void setBeautys(List<Recommendation> beautys) {
        this.beautys = beautys;
    }

    public List<Recommendation> getHeartstones() {
        return heartstones;
    }

    public void setHeartstones(List<Recommendation> heartstones) {
        this.heartstones = heartstones;
    }

    public List<Recommendation> getHuwais() {
        return huwais;
    }

    public void setHuwais(List<Recommendation> huwais) {
        this.huwais = huwais;
    }

    public List<Recommendation> getOverwatchs() {
        return overwatchs;
    }

    public void setOverwatchs(List<Recommendation> overwatchs) {
        this.overwatchs = overwatchs;
    }

    public List<Recommendation> getBlizzards() {
        return blizzards;
    }

    public void setBlizzards(List<Recommendation> blizzards) {
        this.blizzards = blizzards;
    }

    public List<Recommendation> getSports() {
        return sports;
    }

    public void setSports(List<Recommendation> sports) {
        this.sports = sports;
    }

    public List<Recommendation> getQqfeiches() {
        return qqfeiches;
    }

    public void setQqfeiches(List<Recommendation> qqfeiches) {
        this.qqfeiches = qqfeiches;
    }

    public List<Recommendation> getMobilegames() {
        return mobilegames;
    }

    public void setMobilegames(List<Recommendation> mobilegames) {
        this.mobilegames = mobilegames;
    }

    public List<Recommendation> getWangzhes() {
        return wangzhes;
    }

    public void setWangzhes(List<Recommendation> wangzhes) {
        this.wangzhes = wangzhes;
    }

    public List<Recommendation> getDota2s() {
        return dota2s;
    }

    public void setDota2s(List<Recommendation> dota2s) {
        this.dota2s = dota2s;
    }

    public List<Recommendation> getTvgames() {
        return tvgames;
    }

    public void setTvgames(List<Recommendation> tvgames) {
        this.tvgames = tvgames;
    }

    public List<Recommendation> getWebgames() {
        return webgames;
    }

    public void setWebgames(List<Recommendation> webgames) {
        this.webgames = webgames;
    }

    public List<Recommendation> getDnfs() {
        return dnfs;
    }

    public void setDnfs(List<Recommendation> dnfs) {
        this.dnfs = dnfs;
    }

    public List<Recommendation> getMinecrafts() {
        return minecrafts;
    }

    public void setMinecrafts(List<Recommendation> minecrafts) {
        this.minecrafts = minecrafts;
    }

    public List<Lists> getLists() {
        return lists;
    }

    public void setLists(List<Lists> lists) {
        this.lists = lists;
    }
}
