package com.example.myyuekaolianxiti;


import com.example.myyuekaolianxiti.bean.AddBean;
import com.example.myyuekaolianxiti.bean.CartBean;
import com.example.myyuekaolianxiti.bean.GoodsBean;
import com.example.myyuekaolianxiti.bean.LoginBean;
import com.example.myyuekaolianxiti.bean.MessageBean;
import com.example.myyuekaolianxiti.bean.RegistBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface ApiService {
//    http://120.27.23.105/user/login?mobile=13033333333&password=123456
//    https://www.zhaoapi.cn/product/getProducts?pscid=39&page=1
    @GET("user/{login}")
    Flowable<RegistBean> getMessage(@Path("login") String login, @Query("mobile") String mobile, @Query("password") String password);
    @GET("user/{login}")
    Flowable<LoginBean> getLoginMessage(@Path("login") String login, @Query("mobile") String mobile, @Query("password") String password);

    @GET("product/{getProducts}")
    Flowable<MessageBean> getListGoodes(@Path("getProducts") String getProducts, @Query("pscid") int pscid, @Query("page") int page);

    @GET("product/{getProducts}")
    Flowable<GoodsBean> getGoods(@Path("getProducts") String roducts, @Query("pid") String pid);
    @GET("product/{addCart}")
    Flowable<AddBean> getGoodsMessage(@Path("addCart") String login, @Query("uid") String uid, @Query("pid") String pid);
//    http://120.27.23.105/product/getCarts?uid=1262
//    http://120.27.23.105/product/deleteCart?uid=71&pid=1
    @GET("product/{getCarts}")
    Flowable<CartBean> getShoppingCarts(@Path("getCarts") String roducts, @Query("uid") String uid);
    @GET("product/{getCarts}")
    Flowable<AddBean> del(@Path("getCarts") String roducts, @Query("uid") String uid, @Query("pid") String pid);
}
