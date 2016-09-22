package com.qianfeng.manmankan.ui;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgramaChild extends BaseActivity implements ProgramaChildAdapter.OnClickItemListener, View.OnClickListener {

    @BindView(R.id.programa_child_title)
    TextView mTitle;
    @BindView(R.id.programa_child_recyclerview)
    PullToRefreshRecyclerView mRefresh;
    @BindView(R.id.programa_child_back)
    ImageView mBack;
    @BindView(R.id.programa_child_loading)
    ImageView programaChildLoading;
    @BindView(R.id.programa_child_framlayout)
    FrameLayout programaChildFramlayout;
    private ProgramaChildAdapter adapter;
    private List<ProgramaChildModel.DataBean> data = new ArrayList<>();
    private ErrorView errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa_child);
        ButterKnife.bind(this);
        initView();
        setupView(State.DOMN);
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(ProgramaChild.this, "" + position, Toast.LENGTH_SHORT).show();
        String uid = data.get(position).getUid();
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("uid", uid);
        startActivity(intent);

    }

    //
    @Override
    public void onClick(View v) {
        finish();
    }

    public enum State {DOMN, UP}

    private void setupView(final State state) {
        programaChildFramlayout.addView(errorView);
        Intent intent = getIntent();
        String slug = intent.getStringExtra("slug");
        String name = intent.getStringExtra("name");
        mTitle.setText(name);
        Date date = new Date();
        CharSequence format = DateFormat.format("MMddhhmm", date);
        String path = HttpConstants.RECOMMEND_SCROLL_START + slug + HttpConstants.RECOMMEND_SCROLL_MIDDLE + format.toString() + HttpConstants.RECOMMEND_SCROLL_END;
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                programaChildLoading.setVisibility(View.GONE);
                Gson gson = new Gson();
                ProgramaChildModel childModel = gson.fromJson(result, ProgramaChildModel.class);
                data = childModel.getData();
                if (data != null) {
                    switch (state) {
                        case DOMN:
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
                programaChildLoading.setVisibility(View.GONE);
                errorView = new ErrorView(ProgramaChild.this);
                errorView.setButtonListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    programaChildLoading.setVisibility(View.VISIBLE);
                        setupView(State.DOMN);

                    }
                });

                programaChildFramlayout.addView(errorView);
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

    private void initView() {
        ButterKnife.bind(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRefresh.setLayoutManager(layoutManager);
        adapter = new ProgramaChildAdapter(this);
        mRefresh.setAdapter(adapter);
        adapter.setListener(this);
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
                setupView(State.DOMN);
            }
        });
        mBack.setOnClickListener(this);
        AnimationDrawable drawable = (AnimationDrawable) getResources().getDrawable(R.drawable.home_loading);
        programaChildLoading.setBackgroundDrawable(drawable);
        if (drawable != null) {
            drawable.start();
        }

    }
}
