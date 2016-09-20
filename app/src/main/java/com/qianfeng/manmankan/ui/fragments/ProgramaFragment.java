package com.qianfeng.manmankan.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.constans.HttpConstants;
import com.qianfeng.manmankan.model.programas.Programa;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class ProgramaFragment extends BaseFragment {

    public static final String TAG = ProgramaFragment.class.getSimpleName();
    @BindView(R.id.programa_gridview)
    GridView mGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.programa_fragment, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setupView();
    }

    private void setupView() {
        RequestParams params = new RequestParams(HttpConstants.PROGRAMA);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e(TAG,"onSuccess");
                Gson gson = new Gson();
                List<Programa>list = gson.fromJson(result, new TypeToken<List<Programa>>() {}.getType());
                Log.e(TAG,list.size()+"");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    private void initView() {
        ButterKnife.bind(this, layout);


    }
}
