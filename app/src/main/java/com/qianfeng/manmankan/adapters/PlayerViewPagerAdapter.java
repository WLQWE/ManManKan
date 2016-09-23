package com.qianfeng.manmankan.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by 亚奇 on 2016/9/23.
 */
public class PlayerViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> data;
    private String[] tabdata;
    public PlayerViewPagerAdapter(FragmentManager fm,List<Fragment> data,String[] tabdata) {
        super(fm);
            this.data=data;
        this.tabdata=tabdata;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabdata[position];
    }
}
