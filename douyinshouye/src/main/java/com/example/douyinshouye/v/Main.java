package com.example.douyinshouye.v;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.douyinshouye.R;
import com.example.douyinshouye.adapter.MyVpAdapter;
import com.example.douyinshouye.bean.Lunbotu;
import com.example.douyinshouye.bean.UserBean;
import com.example.douyinshouye.p.Presenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;

public class Main extends AppCompatActivity implements IView {

    @BindView(R.id.vvp)
    VerticalViewPager vvp;
    private MyVpAdapter myVpAdapter;
    private List<UserBean.CategoryListBean.AwemeListBean> list = new ArrayList<>();
    private Presenter presenter;
    private int cursor = 0;
    private int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        /*list.add("宋克难");
        list.add("是一个");
        list.add("傻逼");*/

        presenter = new Presenter(this);
        presenter.getUser(cursor, count);
    }

    @Override
    public void onSuccess(Lunbotu lunbotu) {

    }

    @Override
    public void onFailed(String 数据错误) {

    }

    @Override
    public void onUserSuccess(UserBean userBean) {
        List<UserBean.CategoryListBean> category_list = userBean.getCategory_list();
        for (int i = 0; i < category_list.size(); i++) {
            List<UserBean.CategoryListBean.AwemeListBean> aweme_list = category_list.get(i).getAweme_list();
            list.addAll(aweme_list);
        }

        myVpAdapter = new MyVpAdapter(Main.this, list);
        vvp.setAdapter(myVpAdapter);

        vvp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                vvp.getCurrentItem();
                if(position==vvp.getCurrentItem()){

                }
                //Log.i("111",vvp.getCurrentItem()+"fsfs");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onUserFailed(String 数据错误) {

    }
}
