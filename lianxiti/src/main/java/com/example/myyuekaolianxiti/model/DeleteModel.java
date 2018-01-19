package com.example.myyuekaolianxiti.model;

import com.example.myyuekaolianxiti.bean.AddBean;
import com.example.myyuekaolianxiti.presenter.DeletePresenter;
import com.example.myyuekaolianxiti.utils.RetrofitUtils;

import io.reactivex.Flowable;


public class DeleteModel {
    private DeletePresenter presenter;

    public DeleteModel(DeletePresenter presenter) {
        this.presenter = presenter;
    }
    public void getData(String url, String roducts,String uid,String pid){

        Flowable<AddBean> flowable = RetrofitUtils
                .getInstance(url)
                .getApiService()
                .del(roducts ,uid,pid);
        presenter.getMessage(flowable);




    }
}
