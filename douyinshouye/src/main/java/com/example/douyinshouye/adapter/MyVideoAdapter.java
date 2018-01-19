package com.example.douyinshouye.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.douyinshouye.R;
import com.example.douyinshouye.bean.UserBean;

import java.util.List;


public class MyVideoAdapter extends RecyclerView.Adapter<MyVideoAdapter.ViewHolder> {
    private Context context;
    private List<UserBean.CategoryListBean> list;

    public MyVideoAdapter(Context context, List<UserBean.CategoryListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_video, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(list.get(position).getDesc());
        List<UserBean.CategoryListBean.AwemeListBean> aweme_list = list.get(position).getAweme_list();
        for (int i = 0; i < aweme_list.size(); i++) {
            String desc = aweme_list.get(i).getDesc();
            holder.content.setText(desc);
        }
        List<UserBean.CategoryListBean.AwemeListBean> aweme_list1 = list.get(position).getAweme_list();
        MyVideoAdapter2 myVideoAdapter2 = new MyVideoAdapter2(context, aweme_list1);
        holder.rc_video.setAdapter(myVideoAdapter2);
        holder.rc_video.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rc_video;
        TextView text;
        TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            rc_video = (RecyclerView) itemView.findViewById(R.id.rc_video);
            text = (TextView) itemView.findViewById(R.id.user_text);
            content = (TextView) itemView.findViewById(R.id.user_content);
        }
    }
}
