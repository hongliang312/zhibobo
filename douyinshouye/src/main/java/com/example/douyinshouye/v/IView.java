package com.example.douyinshouye.v;


import com.example.douyinshouye.bean.Lunbotu;
import com.example.douyinshouye.bean.UserBean;

public interface IView {
    void onSuccess(Lunbotu lunbotu);
    void onFailed(String 数据错误);
    void onUserSuccess(UserBean userBean);
    void onUserFailed(String 数据错误);
}
