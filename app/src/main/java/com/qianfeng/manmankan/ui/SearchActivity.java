package com.qianfeng.manmankan.ui;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.adapters.ProgramaChildAdapter;
import com.qianfeng.manmankan.constans.State;
import com.qianfeng.manmankan.model.PostParams;
import com.qianfeng.manmankan.model.SearchModel;
import com.qianfeng.manmankan.model.programas.ProgramaChildModel;
import com.qianfeng.manmankan.view.CustomRecyclerView;
import com.qianfeng.manmankan.view.CustomSwipeRefreshLayout;
import com.qianfeng.manmankan.view.ErrorView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity implements PullToRefreshRecyclerView.PagingableListener, CustomSwipeRefreshLayout.OnRefreshListener, ProgramaChildAdapter.OnClickItemListener {

    private static final String TAG = SearchActivity.class.getSimpleName();
    @BindView(R.id.search_back)
    Button mBack;
    @BindView(R.id.search_content)
    EditText mContent;
    @BindView(R.id.search_search)
    Button mSearch;
    @BindView(R.id.search_recycler)
    CustomRecyclerView mRecycler;
    @BindView(R.id.search_loading)
    ImageView loading;
    @BindView(R.id.search_container)
    FrameLayout searchContainer;
    private ProgramaChildAdapter mAdapter;
    private ErrorView errorView;
    private int page;
    private List<ProgramaChildModel.DataBean> data;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecycler.setLayoutManager(layoutManager);
        //开启刷新
        mRecycler.setSwipeEnable(true);
        //设置上拉加载
        mRecycler.setPagingableListener(this);
        //设置下拉刷新
        mRecycler.setOnRefreshListener(this);

        mAdapter = new ProgramaChildAdapter(this);
        mAdapter.setListener(this);
        mRecycler.setAdapter(mAdapter);
        mRecycler.onFinishLoading(true, false);

        //设置动画
        AnimationDrawable drawable = (AnimationDrawable) getResources().getDrawable(R.drawable.home_loading);
        loading.setBackgroundDrawable(drawable);
        if (drawable != null) {
            drawable.start();
        }
    }

    private void setupView(final State state, String content) {
        searchContainer.removeView(errorView);
        if (!content.equals("")) {
            loading.setVisibility(View.VISIBLE);
            RequestParams params = new RequestParams("http://www.quanmin.tv/site/search");
            PostParams postParams = new PostParams();
            PostParams.PBean pBean = new PostParams.PBean();
            pBean.setSize(10);
            pBean.setKey(content);
            pBean.setPage(page);
            pBean.setCategoryId(0);
            postParams.setDevice("862973033141263");
            postParams.setV("2.1.3");
            postParams.setScreen("2");
            postParams.setCh("360zhushou");
            postParams.setSh(1280);
            postParams.setP(pBean);
            postParams.setSw(720);
            postParams.setUid("19b8a4db7d43");
            postParams.setNet("0");
            postParams.setVer("4");
            postParams.setOs("1");
            String json = new Gson().toJson(postParams);
            params.setBodyContent(json);
            x.http().post(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Log.e(TAG, "onSuccess: " + result);
                    mRecycler.setVisibility(View.VISIBLE);
                    loading.setVisibility(View.GONE);
                    Gson gson = new Gson();
                    SearchModel searchModel = gson.fromJson(result, SearchModel.class);
                    data = searchModel.getData().getItem();
                    Log.e(TAG, "onSuccess: " + data.size());
                    if (data != null) {
                        switch (state) {
                            case DOWN:
                                if (data.size() == 0) {
                                    Toast.makeText(SearchActivity.this, "未查询到匹配结果", Toast.LENGTH_SHORT).show();
                                }
                                mAdapter.updateRes(data);
                                break;
                            case UP:
                                mAdapter.addRes(data);
                                break;
                        }
                    }
                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    Log.e(TAG, "onError: ");
                    mRecycler.setVisibility(View.GONE);
                    loading.setVisibility(View.GONE);
                    errorView = new ErrorView(SearchActivity.this);
                    errorView.setButtonListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            loading.setVisibility(View.VISIBLE);
                            setupView(State.DOWN, "");
                        }
                    });
                    searchContainer.addView(errorView);
                }

                @Override
                public void onCancelled(CancelledException cex) {
                    Log.e(TAG, "onCancelled: ");
                }

                @Override
                public void onFinished() {
                    Log.e(TAG, "onFinished: ");
                    mRecycler.setOnRefreshComplete();
                    mRecycler.setOnLoadMoreComplete();
                }
            });
        } else {
            Toast.makeText(SearchActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.search_back, R.id.search_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_back:
                finish();
                break;
            case R.id.search_search:
                content = mContent.getText().toString();
                setupView(State.DOWN, content);
                break;
        }
    }

    @Override
    public void onLoadMoreItems() {
        page = 0;
        setupView(State.UP, content);
    }

    @Override
    public void onRefresh() {
        page++;
        setupView(State.DOWN, content);
    }

    @Override
    public void onClick(View view, int position) {
        String uid = data.get(position).getUid();
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("uid", uid);
        startActivity(intent);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return false;
    }
}
