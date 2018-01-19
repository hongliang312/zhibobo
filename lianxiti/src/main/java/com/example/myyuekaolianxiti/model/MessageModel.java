package com.example.myyuekaolianxiti.model;

import com.example.myyuekaolianxiti.bean.GoodsBean;
import com.example.myyuekaolianxiti.bean.MessageBean;
import com.example.myyuekaolianxiti.presenter.MessagePresenter;
import com.example.myyuekaolianxiti.utils.RetrofitUtils;

import io.reactivex.Flowable;

/**
 * Created by 知足 on 2018/1/14.
 */

public class MessageModel {
    private MessagePresenter presenter;

    public MessageModel(MessagePresenter presenter) {
        this.presenter = presenter;
    }
    public void getData(String url, String roducts,String pid, int pscid,int page){
        if(pid.equals("")){
            Flowable<MessageBean> flowable = RetrofitUtils.getInstance(url).getApiService().getListGoodes(roducts,pscid, page);
            presenter.getMessage(flowable);
        }else{
            Flowable<GoodsBean> flowable2 = RetrofitUtils.getInstance(url).getApiService().getGoods(roducts,pid );
            presenter.getNews(flowable2);
        }





    }
}
