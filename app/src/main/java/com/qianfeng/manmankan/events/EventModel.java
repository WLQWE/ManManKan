package com.qianfeng.manmankan.events;

import com.qianfeng.manmankan.model.playermodels.PlayerModel;

import java.util.List;

/**
 * Created by 亚奇 on 2016/9/23.
 */
public class EventModel {
    private List<PlayerModel.RankTotalBean> data;
       private List<PlayerModel.RankTotalBean> dataTwo;
    public List<PlayerModel.RankTotalBean> getData() {
        return data;
    }

    public void setData(List<PlayerModel.RankTotalBean> data) {
        this.data = data;
    }

    public List<PlayerModel.RankTotalBean> getDataTwo() {
        return dataTwo;
    }

    public void setDataTwo(List<PlayerModel.RankTotalBean> dataTwo) {
        this.dataTwo = dataTwo;
    }
}
