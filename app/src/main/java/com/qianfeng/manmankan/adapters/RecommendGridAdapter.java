package com.qianfeng.manmankan.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.manmankan.R;
import com.qianfeng.manmankan.model.recommends.Recommendation;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SacuraQH on 2016/9/21.
 */
public class RecommendGridAdapter extends BaseAdapter implements View.OnClickListener {

    private static final String TAG = RecommendGridAdapter.class.getSimpleName();
    private List<Recommendation> data;

    private LayoutInflater inflater;

    private ImageOptions options;

    private ImageOptions optionsImg;

    private OnGridItemClickListener listener;

    private boolean flag;

    private int i = 1;

    public void setListener(OnGridItemClickListener listener) {
        this.listener = listener;
    }

    public RecommendGridAdapter(Context context, List<Recommendation> data, boolean flag) {
        this.flag = flag;
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
        options = new ImageOptions.Builder()
                .setCircular(true)
                .build();
        optionsImg = new ImageOptions.Builder()
                .setLoadingDrawableId(R.mipmap.live_default)
                .build();
    }

    public void changeRes() {
        Log.e(TAG, "updateRes: " + data.size());
        Collections.swap(this.data, 0, 2 * i);
        Collections.swap(this.data, 1, 2 * i + 1);
        notifyDataSetChanged();
        i++;
        if (2 * i + 1 >= data.size()) {
            i = 1;
        }
    }

    @Override
    public int getCount() {
        if (flag) {
            return 2;
        }
        return data.size();
    }

    @Override
    public Recommendation getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.programa_child_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(R.id.view_tag_one,holder);
        } else {
            holder = (ViewHolder) convertView.getTag(R.id.view_tag_one);
        }
        x.image().bind(holder.programaChildShowimg, data.get(position).getLink_object().getThumb(), optionsImg);
        int num = Integer.parseInt(data.get(position).getLink_object().getView());
        if (num > 10000) {
            float count = num / 1000 / 10.0f;
            holder.programaChildOnlinenum.setText(count + "万");
        } else {
            holder.programaChildOnlinenum.setText(String.valueOf(num));
        }
        holder.programaChildUser.setText(data.get(position).getLink_object().getNick());
        holder.programaChildComtentname.setText(data.get(position).getLink_object().getIntro());
        x.image().bind(holder.programaChildUserpic, data.get(position).getLink_object().getAvatar(), options);
        convertView.setTag(R.id.view_tag_two,data.get(position).getLink_object().getUid());
        convertView.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick((String) v.getTag(R.id.view_tag_two));
    }

    static class ViewHolder {
        @BindView(R.id.programa_child_showimg)
        ImageView programaChildShowimg;
        @BindView(R.id.programa_child_onlinenum)
        TextView programaChildOnlinenum;
        @BindView(R.id.programa_child_userpic)
        ImageView programaChildUserpic;
        @BindView(R.id.programa_child_user)
        TextView programaChildUser;
        @BindView(R.id.programa_child_comtentname)
        TextView programaChildComtentname;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public interface OnGridItemClickListener{
        void onItemClick(String uid);
    }
}
