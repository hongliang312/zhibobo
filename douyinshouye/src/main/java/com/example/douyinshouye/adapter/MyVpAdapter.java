package com.example.douyinshouye.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.douyinshouye.R;
import com.example.douyinshouye.bean.UserBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class MyVpAdapter extends PagerAdapter {
    private Context context;
    private List<UserBean.CategoryListBean.AwemeListBean> list;

    public MyVpAdapter(Context context, List<UserBean.CategoryListBean.AwemeListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = View.inflate(context, R.layout.vp_layout, null);
        final JCVideoPlayerStandard videoplayer = (JCVideoPlayerStandard) view.findViewById(R.id.videoplayer);
        WebView webView = new WebView(context);
        webView.loadUrl(list.get(position).getVideo().getDownload_addr().getUrl_list().get(0));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            //页面加载开始
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            //页面加载完成
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String realUrl = url;
//这个realUrl即为重定向之后的地址
                boolean setUp = videoplayer.setUp(realUrl, JCVideoPlayer.SCREEN_LAYOUT_LIST, list.get(position).getDesc());
                if (setUp) {
                    videoplayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(context).load(list.get(position).getVideo().getCover().getUrl_list().get(0)).into(videoplayer.thumbImageView);
                 //  videoplayer.startPlayLogic();
               }
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
