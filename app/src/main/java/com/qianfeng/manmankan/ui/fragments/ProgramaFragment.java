package com.qianfeng.manmankan.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.adapters.ProgramaAdapter;
import com.qianfeng.manmankan.constans.HttpConstants;
import com.qianfeng.manmankan.model.programas.ProgramaModel;
import com.qianfeng.manmankan.ui.ProgramaChild;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SacuraQH on 2016/9/20.
 */
public class ProgramaFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private List<ProgramaModel>list;
    public static final String TAG = ProgramaFragment.class.getSimpleName();
    @BindView(R.id.programa_gridview)
    GridView mGridView;
    private ProgramaAdapter adapter;

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
                Log.e(TAG,result);
                Gson gson = new Gson();
               list= gson.fromJson(result, new TypeToken<List<ProgramaModel>>() {}.getType());
                Log.e(TAG,list.size()+"");
                if (list!=null) {
                    adapter.updateRes(list);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG,"onSuccess");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG,"onCancelled");
            }

            @Override
            public void onFinished() {
                Log.e(TAG,"onFinished");
            }
        });

    }

    private void initView() {
        ButterKnife.bind(this, layout);
        adapter = new ProgramaAdapter(getContext());
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext() ,"第"+position+"个", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), ProgramaChild.class);
        if (list!=null) {
            intent.putExtra("slug",list.get(position).getSlug());
            intent.putExtra("name",list.get(position).getName());
        }
        startActivity(intent);

    }
}
