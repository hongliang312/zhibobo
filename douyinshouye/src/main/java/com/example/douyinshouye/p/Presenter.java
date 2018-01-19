package com.example.douyinshouye.p;


import com.example.douyinshouye.bean.Lunbotu;
import com.example.douyinshouye.bean.UserBean;
import com.example.douyinshouye.m.Model;
import com.example.douyinshouye.v.IView;

public class Presenter implements IPre {
    private IView iView;
    private Model model;

    public Presenter(IView iView) {
        this.iView = iView;
        model=new Model();
    }

    public void getLunbo(){
        model.getLunbo(this);
    }

    public void getUser(int cursor, int count){
        model.getUser(cursor,count,this);
    }

    @Override
    public void onSuccess(Lunbotu lunbotu) {
        iView.onSuccess(lunbotu);
    }

    @Override
    public void onFailed(String 数据错误) {
        iView.onFailed(数据错误);
    }

    @Override
    public void onUserSuccess(UserBean userBean) {
        iView.onUserSuccess(userBean);
    }

    @Override
    public void onUserFailed(String 数据错误) {
        iView.onUserFailed(数据错误);
    }
}
