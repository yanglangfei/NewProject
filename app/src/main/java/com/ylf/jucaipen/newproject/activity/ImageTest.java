package com.ylf.jucaipen.newproject.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.ylf.jucaipen.newproject.R;
import com.ylf.jucaipen.newproject.been.Person;
import com.ylf.jucaipen.newproject.utils.CannelUtils;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2015/11/17.
 */
public class ImageTest extends Activity {
    private Context context=ImageTest.this;
    private ImageView iv_image;
    private  String url="http://avatar.csdn.net/blogpic/20150925104413479.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_image);
        initView();
        Realm realm=Realm.getInstance(new RealmConfiguration.Builder(this).name("myRealm.realm").build());
        realm.beginTransaction();
        Person p= realm.createObject(Person.class);
        p.setAddress("陕西");
        p.setAge(12);
        p.setId(1);
        p.setSex(2);
        p.setName("小明");
        realm.commitTransaction();
    }
    private void initView() {
        iv_image= (ImageView) findViewById(R.id.iv_image);
        ImageSize size=new ImageSize(100,100);
        //使用DisplayImageOptions+loadImage配置加载图片
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565).build();
        ImageLoader.getInstance().loadImage(url, size, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String s, View view) {
                Log.i("111","开始加载");
            }

            @Override
            public void onLoadingFailed(String s, View view, FailReason failReason) {
                Log.i("111","加载失败");

            }

            @Override
            public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                Log.i("111","加载完成");
                iv_image.setImageBitmap(bitmap);
            }

            @Override
            public void onLoadingCancelled(String s, View view) {
                Log.i("111","取消加载");
            }
        });
        String cannel=CannelUtils.getMetaData(this, "cannel");
        Log.i("111","发布渠道："+cannel);
   /*     //使用使用DisplayImageOptions+displayImage加载图片
        DisplayImageOptions options1=new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //加载图片的时候显示正在加载的图
                .cacheInMemory(true)  //缓存至内存
               .cacheOnDisk(true)  //缓存值SDcard
               .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoader.getInstance().displayImage(url,iv_image,options1);*/
    }


}
