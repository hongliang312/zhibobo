package com.example.douyinshouye.m;


import com.example.douyinshouye.bean.Lunbotu;
import com.example.douyinshouye.bean.UserBean;
import com.example.douyinshouye.p.IPre;
import com.example.douyinshouye.utils.RetiofitVip;
import com.example.douyinshouye.utils.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;



public class Model {
    public void getLunbo(final IPre iPre){
        RetiofitVip retiofitVip = RetrofitHelper.getRetrofit("http://api.amemv.com/").create(RetiofitVip.class);
        retiofitVip.getlun("1128","no_retry","23028350734","42386607829")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Lunbotu>() {
                    @Override
                    public void accept(Lunbotu lunbotu) throws Exception {
                        if (lunbotu != null) {
                            iPre.onSuccess(lunbotu);
                        } else {
                            iPre.onFailed("数据错误");
                        }
                    }
                });
    }

    public void getUser(int cursor, int count,final IPre iPre){
        RetiofitVip retiofitVip = RetrofitHelper.getRetrofit("http://api.amemv.com/").create(RetiofitVip.class);
        retiofitVip.getuser(cursor,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {
                        if (userBean != null) {
                            iPre.onUserSuccess(userBean);
                        } else {
                            iPre.onUserFailed("数据错误");
                        }
                    }
                });
    }
}
