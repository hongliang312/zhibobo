package com.example.douyinshouye.utils;

import com.example.douyinshouye.bean.Lunbotu;
import com.example.douyinshouye.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetiofitVip {
    //获取tablayout的内容
    //http://api.amemv.com/aweme/v1/find/&aid=1128
   // http://api.amemv.com/aweme/v1/find/?
    // retry_type=no_retry
    // &iid=23028350734
    // &device_id=42386607829
    // &aid=1128
    // &app_name=aweme&version_code=169&version_name=1.6.9&device_platform=android&ssmix=a&device_type=Redmi+Note+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0&uuid=863411038560129&openudid=87f33cdff2475c29&manifest_version_code=169&resolution=1080*1920&dpi=480&update_version_code=1692&_rticket=1515741876519&ts=1515741878&as=a1d5b625a65bca22e8&cp=67b8a3566c885d23e1
    @GET("aweme/v1/find/")
    Observable<Lunbotu> getlun(@Query("aid") String aid,
                               @Query("retry_type") String retry_type,
                               @Query("iid") String iid,
                               @Query("device_id") String device_id);

     @GET("aweme/v1/category/list/")
     Observable<UserBean> getuser(@Query("cursor") int cursor, @Query("count") int count);

    //http://api.amemv.com/aweme/v1/category/list/?cursor=0&count=5
    // &retry_type=no_retry
    // &iid=23028350734
    // &device_id=42386607829
    // &ac=wifi
    // &channel=xiaomi
    // &aid=1128
    // &app_name=aweme
    // &version_code=169
    // &version_name=1.6.9
    // &device_platform=android
    // &ssmix=a
    // &device_type=Redmi+Note+4
    // &device_brand=Xiaomi
    // &language=zh
    // &os_api=23
    // &os_version=6.0
    // &uuid=863411038560129
    // &openudid=87f33cdff2475c29
    // &manifest_version_code=169
    // &resolution=1080*1920
    // &dpi=480
    // &update_version_code=1692
    // &_rticket=1515741876521
    // &ts=1515741878
    // &as=a195564586db1ac208
    // &cp=61b2af5864845224e1

}
