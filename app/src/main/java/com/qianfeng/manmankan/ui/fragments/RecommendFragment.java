package com.qianfeng.manmankan.ui.fragments;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.adapters.RecommendAdapter;
import com.qianfeng.manmankan.adapters.RecommendHeaderAdapter;
import com.qianfeng.manmankan.constans.HttpConstants;
import com.qianfeng.manmankan.constans.State;
import com.qianfeng.manmankan.model.recommends.Index;
import com.qianfeng.manmankan.model.recommends.Recommendation;
import com.qianfeng.manmankan.model.recommends.Recommends;
import com.qianfeng.manmankan.ui.PlayerActivity;
import com.qianfeng.manmankan.ui.ProgramaChild;
import com.qianfeng.manmankan.view.CustomRecyclerView;
import com.qianfeng.manmankan.view.CustomSwipeRefreshLayout;
import com.qianfeng.manmankan.view.ErrorView;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class RecommendFragment extends BaseFragment implements PullToRefreshRecyclerView.PagingableListener, SwipeRefreshLayout.OnRefreshListener, BGABanner.OnItemClickListener, BGABanner.Adapter, RecommendHeaderAdapter.OnItemClickListener, CustomSwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = RecommendFragment.class.getSimpleName();

    @BindView(R.id.recommend_recycler)
    CustomRecyclerView recommendRecycler;

    @BindView(R.id.recommend_loading)
    ImageView loading;

    @BindView(R.id.recommend_container)
    FrameLayout recommendContainer;

    BGABanner mHeaderPager;
    RecyclerView mHeaderRecycler;
    private RecommendHeaderAdapter headerAdapter;
    private RecommendAdapter mAdapter;
    private View headerView;
    private ErrorView errorView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.recommend_fragment, container, false);

        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView(State.DOWN);
    }

    private void initView() {
        ButterKnife.bind(this, layout);
        headerView = View.inflate(getContext(), R.layout.recommend_header, null);
        headerView.setVisibility(View.INVISIBLE);
        mHeaderPager = (BGABanner) headerView.findViewById(R.id.recommend_header_pager);
        mHeaderRecycler = (RecyclerView) headerView.findViewById(R.id.recommend_header_recycler);
        mHeaderPager.setOnItemClickListener(this);
        recommendRecycler.addHeaderView(headerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recommendRecycler.setLayoutManager(layoutManager);
        //开启刷新
        recommendRecycler.setSwipeEnable(true);
        //设置上拉加载
        recommendRecycler.setPagingableListener(this);
        //设置下拉刷新
        recommendRecycler.setOnRefreshListener(this);
        //为轮播图设置适配器
        mHeaderPager.setAdapter(this);
        //为头布局的RecyclerView设置管理器和适配器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mHeaderRecycler.setLayoutManager(linearLayoutManager);
        headerAdapter = new RecommendHeaderAdapter(getContext());
        headerAdapter.setListener(this);
        mHeaderRecycler.setAdapter(headerAdapter);
        //
        mAdapter = new RecommendAdapter(getContext());
        recommendRecycler.setAdapter(mAdapter);
        recommendRecycler.onFinishLoading(true, false);

        //设置动画
        AnimationDrawable drawable = (AnimationDrawable) getResources().getDrawable(R.drawable.home_loading);
        loading.setBackgroundDrawable(drawable);
        if (drawable != null) {
            drawable.start();
        }
    }

    private void setupView(final State state) {
        recommendContainer.removeView(errorView);
        RequestParams requestParams = new RequestParams(HttpConstants.RECOMMEND);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: ");
                loading.setVisibility(View.GONE);
                headerView.setVisibility(View.VISIBLE);
                Gson gson = new Gson();
                Recommends recommends = gson.fromJson(result, Recommends.class);
                List<String> tips = new ArrayList<>();
                List<Index> datas = new ArrayList<>();
                List<Index> indexs = recommends.getIndexs();
                for (Index index : indexs) {
                    String recommend_image = index.getLink_object().getRecommend_image();
                    if (recommend_image != "") {
                        tips.add(index.getLink_object().getTitle());
                        datas.add(index);
                    }
                }

                List<List<Recommendation>> data = new ArrayList<>();
                data.add(recommends.getRecommendations());
                data.add(recommends.getLols());
                data.add(recommends.getBeautys());
                data.add(recommends.getHeartstones());
                data.add(recommends.getHuwais());
                data.add(recommends.getOverwatchs());
                data.add(recommends.getBlizzards());
                data.add(recommends.getSports());
                data.add(recommends.getQqfeiches());
                data.add(recommends.getMobilegames());
                data.add(recommends.getWangzhes());
                data.add(recommends.getDota2s());
                data.add(recommends.getTvgames());
                data.add(recommends.getWebgames());
                data.add(recommends.getDnfs());
                data.add(recommends.getMinecrafts());
                switch (state) {
                    case DOWN:
                        //为轮播图设置数据
                        mHeaderPager.setData(datas, tips);
                        //为头布局的RecyclerView更新数据
                        headerAdapter.updateRes(recommends.getClassifications());
                        //RecyclerView更新数据
                        mAdapter.updateRes(data, recommends.getLists());

                        break;
                    case UP:

                        break;
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: ");
                loading.setVisibility(View.GONE);
                errorView = new ErrorView(getContext());
                errorView.setButtonListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loading.setVisibility(View.VISIBLE);
                        setupView(State.DOWN);
                    }
                });
                recommendContainer.addView(errorView);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled: ");
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished: ");
                recommendRecycler.setOnLoadMoreComplete();
                recommendRecycler.setOnRefreshComplete();
            }
        });
    }

    @Override
    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        String recommend_image = ((Index) model).getLink_object().getRecommend_image();
        Picasso.with(getActivity())
                .load(recommend_image)
                .placeholder(R.mipmap.ads_default)
                .into((ImageView) view);
    }

    @OnClick(R.id.recommend_focus)
    public void onClick() {
        Toast.makeText(getActivity(), "添加喜爱", Toast.LENGTH_SHORT).show();
    }

    //上拉加载
    @Override
    public void onLoadMoreItems() {

    }

    //下拉刷新
    @Override
    public void onRefresh() {
        setupView(State.DOWN);
    }

    //轮播图的点击监听
    @Override
    public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
        Intent intent = new Intent(getContext(), PlayerActivity.class);
        intent.putExtra("uid", ((Index) model).getLink_object().getUid());
        getContext().startActivity(intent);
    }

    //头布局RecyclerView的点击监听
    @Override
    public void OnItemClick(String classification, String title) {
        Intent intent = new Intent(getActivity(), ProgramaChild.class);
        intent.putExtra("slug", classification);
        intent.putExtra("name", title);
        getContext().startActivity(intent);
    }
}
