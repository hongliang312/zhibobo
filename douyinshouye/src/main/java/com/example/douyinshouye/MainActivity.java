package com.example.douyinshouye;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.douyinshouye.adapter.MyAdapter;
import com.example.douyinshouye.bean.Lunbotu;
import com.example.douyinshouye.bean.UserBean;
import com.example.douyinshouye.p.Presenter;
import com.example.douyinshouye.v.IView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.xrc)
    XRecyclerView xrc;
    private Presenter presenter;
    private int cursor = 0;
    private int count = 5;
    private List<Lunbotu.BannerBean> ban = new ArrayList<>();
    private List<UserBean.CategoryListBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new Presenter(this);
        presenter.getLunbo();
        presenter.getUser(cursor, count);

        //设置可上拉
        xrc.setPullRefreshEnabled(true);
        xrc.setLoadingMoreEnabled(true);
        //设置上拉下拉样式
        xrc.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrc.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotatePulse);

        xrc.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                cursor++;
                count = count + 5;
                presenter.getUser(cursor, count);
                myAdapter.notifyDataSetChanged();
                xrc.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                // cursor++;
                count = count + 5;
                presenter.getUser(cursor, count);
                myAdapter.notifyDataSetChanged();
                xrc.loadMoreComplete();
            }
        });

    }

    @Override
    public void onSuccess(Lunbotu lunbotu) {
        List<Lunbotu.BannerBean> banner = lunbotu.getBanner();
        ban.addAll(banner);
    }

    @Override
    public void onFailed(String 数据错误) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
    }

    @Override
    public void onUserSuccess(UserBean userBean) {
        List<UserBean.CategoryListBean> category_list = userBean.getCategory_list();
        list.addAll(category_list);
        xrc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myAdapter = new MyAdapter(MainActivity.this, ban, list);
        xrc.setAdapter(myAdapter);
    }

    @Override
    public void onUserFailed(String 数据错误) {

    }
}