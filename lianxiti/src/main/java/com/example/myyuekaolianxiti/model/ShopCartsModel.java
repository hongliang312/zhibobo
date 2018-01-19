package com.example.myyuekaolianxiti.model;

import com.example.myyuekaolianxiti.bean.CartBean;
import com.example.myyuekaolianxiti.presenter.ShopCartsPresenter;
import com.example.myyuekaolianxiti.utils.RetrofitUtils;

import io.reactivex.Flowable;

/**
 * Created by 知足 on 2018/1/14.
 */

public class ShopCartsModel {

    private ShopCartsPresenter presenter;

    public ShopCartsModel(ShopCartsPresenter presenter) {
        this.presenter = presenter;
    }
    public void getData(String url, String roducts,String uid){

        Flowable<CartBean> flowable = RetrofitUtils
                .getInstance(url)
                .getApiService()
                .getShoppingCarts(roducts ,uid);
        presenter.getMessage(flowable);




    }

}
