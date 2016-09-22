package com.qianfeng.manmankan.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
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

public class SearchActivity extends AppCompatActivity implements PullToRefreshRecyclerView.PagingableListener, CustomSwipeRefreshLayout.OnRefreshListener {

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
        if (!content.equals("")) {
            loading.setVisibility(View.VISIBLE);
            searchContainer.removeView(errorView);
            RequestParams params = new RequestParams("http://www.quanmin.tv/site/search");
            PostParams.PBean pBean = new PostParams.PBean();
            pBean.setSize(10);
            pBean.setKey(content);
            pBean.setPage(0);
            pBean.setCategoryId(0);
            params.addBodyParameter("device", "862973033141263");
            params.addBodyParameter("v", "2.1.3");
            params.addBodyParameter("screen", "2");
            params.addBodyParameter("ch", "360zhushou");
            params.addBodyParameter("sh", "1280");
            params.addBodyParameter("p", pBean, null);
            params.addBodyParameter("sw", "720");
            params.addBodyParameter("uid", "19b8a4db7d43");
            params.addBodyParameter("net", "0");
            params.addBodyParameter("ver", "4");
            params.addBodyParameter("os", "1");

            x.http().post(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Log.e(TAG, "onSuccess: "+result);
                    loading.setVisibility(View.GONE);
                    Gson gson = new Gson();
                    ProgramaChildModel childModel = gson.fromJson(result, ProgramaChildModel.class);
                    List<ProgramaChildModel.DataBean> data = childModel.getData();
                    if (data != null) {
                        switch (state) {
                            case DOWN:
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

                }

                @Override
                public void onFinished() {

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
                String content = mContent.getText().toString();
                setupView(State.DOWN, content);
                break;
        }
    }

    @Override
    public void onLoadMoreItems() {
        setupView(State.UP, mContent.getText().toString());
    }

    @Override
    public void onRefresh() {
        setupView(State.DOWN, mContent.getText().toString());
    }
}
