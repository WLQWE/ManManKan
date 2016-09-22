package com.qianfeng.manmankan.ui.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.adapters.ProgramaChildAdapter;
import com.qianfeng.manmankan.constans.HttpConstants;
import com.qianfeng.manmankan.model.programas.ProgramaChildModel;
import com.qianfeng.manmankan.view.ErrorView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class LiveFragment extends BaseFragment implements ProgramaChildAdapter.OnClickItemListener {

    public static final String TAG = LiveFragment.class.getSimpleName();
    @BindView(R.id.live_recyclerview)
    PullToRefreshRecyclerView mRefresh;
    @BindView(R.id.live_loading)
    ImageView liveLoading;
    @BindView(R.id.live_framlayout)
    FrameLayout liveFramlayout;
    private ProgramaChildAdapter adapter;
    private ErrorView errorView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.live_fragment, container, false);


        ButterKnife.bind(this, layout);
        return layout;
    }

    public enum State {DOWN, UP}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView(State.DOWN);
    }

    private void setupView(final State state) {
        mRefresh.setVisibility(View.VISIBLE);
        liveFramlayout.removeView(errorView);
        String path = HttpConstants.LIVE_START + HttpConstants.LIVE_END;
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            private List<ProgramaChildModel.DataBean> data;

            @Override
            public void onSuccess(String result) {
                liveLoading.setVisibility(View.GONE);
                Gson gson = new Gson();
                ProgramaChildModel child = gson.fromJson(result, ProgramaChildModel.class);
                data = child.getData();
                if (data != null) {
                    switch (state) {
                        case DOWN:
                            adapter.updateRes(data);
                            break;
                        case UP:
                            adapter.addRes(data);
                            break;
                    }
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                mRefresh.setVisibility(View.GONE);
                liveLoading.setVisibility(View.GONE);
                errorView=new ErrorView(getContext());
                errorView.setButtonListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        liveLoading.setVisibility(View.VISIBLE);
                        setupView(State.DOWN);
                    }
                });
                liveFramlayout.addView(errorView);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                mRefresh.setOnRefreshComplete();
                mRefresh.setOnLoadMoreComplete();
            }
        });


    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(getContext(), "老" + position, Toast.LENGTH_SHORT).show();
    }


    private void initView() {
        ButterKnife.bind(this, layout);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        mRefresh.setLayoutManager(manager);
        adapter = new ProgramaChildAdapter(getContext());
        adapter.setListener(this);
        mRefresh.setAdapter(adapter);
        mRefresh.setSwipeEnable(true);
        mRefresh.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener() {
            @Override
            public void onLoadMoreItems() {
                setupView(State.UP);
            }

        });
        mRefresh.setOnRefreshListener(new PullToRefreshRecyclerView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setupView(State.DOWN);
            }
        });
        AnimationDrawable drawable = (AnimationDrawable) getResources().getDrawable(R.drawable.home_loading);
        liveLoading.setBackgroundDrawable(drawable);
        if (drawable != null) {
            drawable.start();
        }

    }
}
