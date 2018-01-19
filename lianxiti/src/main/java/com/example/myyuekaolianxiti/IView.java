package com.example.myyuekaolianxiti;


import com.example.myyuekaolianxiti.bean.AddBean;

public interface IView {
    void onSuccess(Object o);
    void onFailed(Exception e);

    void success(AddBean loginBean);
}
