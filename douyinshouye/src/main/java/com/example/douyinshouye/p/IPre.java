package com.example.douyinshouye.p;


import com.example.douyinshouye.bean.Lunbotu;
import com.example.douyinshouye.bean.UserBean;

public interface IPre {
    void onSuccess(Lunbotu lunbotu);
    void onFailed(String 数据错误);
    void onUserSuccess(UserBean userBean);
    void onUserFailed(String 数据错误);
}
