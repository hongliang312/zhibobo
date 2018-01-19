package com.example.douyinshouye.v;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.douyinshouye.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;



public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard videoplayer;
    private String pic;
    private String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        pic = intent.getStringExtra("pic");
        desc = intent.getStringExtra("desc");

        WebView webView = new WebView(this);
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
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
                boolean setUp = videoplayer.setUp(realUrl, JCVideoPlayer.SCREEN_LAYOUT_LIST, desc);
                if (setUp) {
                    videoplayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(Main2Activity.this).load(pic).into(videoplayer.thumbImageView);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
