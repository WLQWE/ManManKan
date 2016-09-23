package com.qianfeng.manmankan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.ui.fragments.LiveFragment;
import com.qianfeng.manmankan.ui.fragments.MineFragment;
import com.qianfeng.manmankan.ui.fragments.ProgramaFragment;
import com.qianfeng.manmankan.ui.fragments.RecommendFragment;

import java.lang.reflect.InvocationTargetException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.search)
    Button search;
    @BindView(R.id.bottom_btn)
    RadioGroup bottomBtn;

    private Fragment mShowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        bottomBtn.setOnCheckedChangeListener(this);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        mShowFragment = new RecommendFragment();
        transaction.add(R.id.container, mShowFragment);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.recommend:
                search.setVisibility(View.VISIBLE);
                switchPager(RecommendFragment.TAG, RecommendFragment.class);
                break;
            case R.id.programa:
                search.setVisibility(View.VISIBLE);
                switchPager(ProgramaFragment.TAG, ProgramaFragment.class);
                break;
            case R.id.live:
                search.setVisibility(View.VISIBLE);
                switchPager(LiveFragment.TAG, LiveFragment.class);
                break;
            case R.id.mine:
                search.setVisibility(View.GONE);
                switchPager(MineFragment.TAG, MineFragment.class);
                break;
        }
    }

    //    第一屏的Fragment间的切换方法
    private void switchPager(String tag, Class<? extends Fragment> cls) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.hide(mShowFragment);
        //                根据TAG去Fragment中查找碎片
        mShowFragment = manager.findFragmentByTag(tag);
        if (mShowFragment != null) {
            transaction.show(mShowFragment);
        } else {
            try {
                mShowFragment = cls.getConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            transaction.add(R.id.container, mShowFragment, tag);
        }
        transaction.commit();

    }

    @OnClick(R.id.search)
    public void onClick() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}
