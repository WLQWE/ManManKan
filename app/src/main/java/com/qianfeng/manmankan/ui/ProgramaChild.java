package com.qianfeng.manmankan.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.adapters.ProgramaChildAdapter;
import com.qianfeng.manmankan.constans.HttpConstants;
import com.qianfeng.manmankan.model.programas.ProgramaChildModel;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgramaChild extends AppCompatActivity {

    @BindView(R.id.programa_child_title)
    TextView mTitle;
    @BindView(R.id.programa_child_recyclerview)
    PullToRefreshRecyclerView mRefresh;
    private ProgramaChildAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        setupView(State.DOMN);
    }

    public enum State{DOMN,UP}

    private void setupView(final State state) {

        Intent intent = getIntent();
        String slug = intent.getStringExtra("slug");
        String name = intent.getStringExtra("name");
        mTitle.setText(name);
        Date date = new Date();
        CharSequence format = DateFormat.format("MMddhhmm", date);
        Log.e("tag",format.toString());
        String path = HttpConstants.RECOMMEND_SCROLL_START + slug + HttpConstants.RECOMMEND_SCROLL_MIDDLE + format.toString() + HttpConstants.RECOMMEND_SCROLL_END;
        RequestParams params = new RequestParams(path);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ProgramaChildModel childModel = gson.fromJson(result, ProgramaChildModel.class);
                List<ProgramaChildModel.DataBean> data = childModel.getData();
                if (data!=null) {
                    switch (state){
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

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                mRefresh.setOnRefreshComplete();
            }
        });


    }

    private void initView() {
        setContentView(R.layout.activity_programa_child);
        ButterKnife.bind(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRefresh.setLayoutManager(layoutManager);
        adapter = new ProgramaChildAdapter(this);
        mRefresh.setAdapter(adapter);
        mRefresh.setSwipeEnable(true);
        mRefresh.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener(){
            @Override
            public void onLoadMoreItems() {
                setupView(State.UP);
            }

        });
        mRefresh.setOnRefreshListener(new PullToRefreshRecyclerView.OnRefreshListener(){
            @Override
            public void onRefresh() {
                setupView(State.DOMN);
            }
        });



    }
}
