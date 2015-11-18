package com.ylf.jucaipen.newproject.activity;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapCommonUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.ylf.jucaipen.newproject.R;
import com.ylf.jucaipen.newproject.cache.FileUtils;

public class XUtilsTest extends Activity {
    private  String url="http://avatar.csdn.net/blogpic/20150925104413479.jpg";
    private ImageView iv_x;

    private BitmapDisplayConfig displayConfig;
    private BitmapUtils utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_xutil);
        initView();

    }

    private void initView() {
        iv_x= (ImageView) findViewById(R.id.iv_x);
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        FileUtils fileUtils=new FileUtils(this, "jereh");
        utils=new BitmapUtils(this,fileUtils.getCacheDir(),cacheSize);
        displayConfig=new BitmapDisplayConfig();
        //displayConfig.setShowOriginal(true); // 显示原始图片,不压缩, 尽量不要使用, 图片太大时容易OOM。
        //utils.configDefaultBitmapMaxSize(BitmapCommonUtils.getScreenSize(mActivity));
        displayConfig.setBitmapMaxSize(BitmapCommonUtils.getScreenSize(this));
        AlphaAnimation animation=new AlphaAnimation(0.1f,1.0f);
        animation.setDuration(500);
        displayConfig.setAnimation(animation);
        utils.display(iv_x, url, displayConfig);
        Log.i("111", "二次");
        Toast.makeText(this,"二次",Toast.LENGTH_LONG).show();
    }

/*    private void loadData(){
        RequestParams params=new RequestParams();
        params.addQueryStringParameter("categoryId","2");//设置参数
        HttpUtils httpUtils=new HttpUtils();
        //向服务器发送请求
        httpUtils.send(HttpMethod.POST, "http://avatar.csdn.net/blogpic/20150925104413479.jpg", params,new RequestCallBack<String>(){
            @Override
            public void onFailure(HttpException e, String m) {
                Log.i("jereh", e.getExceptionCode()+" "+m);
            }
            @Override
            public void onSuccess(ResponseInfo<String> info) {//后台执行完成后回调，并传入返回数据
                Gson gson=new Gson();//创建gson组件
                //将info.result服务器返回的JSON数据，使用Gson解析
                List<ImageInfo> imageInfo=gson.fromJson(info.result, new TypeToken<ArrayList<ImageInfo>>(){}.getType());
                imageInfoList.addAll(imageInfo);
                vpImagePager.setAdapter(adapter);
            }

        });
    }*/







}
