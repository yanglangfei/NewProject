package com.ylf.jucaipen.newproject.adapter;

import java.util.List;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapCommonUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.ylf.jucaipen.newproject.cache.FileUtils;

public class PhotoBrowseAdapter extends PagerAdapter {

    private Activity mActivity;
    private List<String> imageList;
    private LayoutInflater inflate;
    private BitmapUtils utils;
    private BitmapDisplayConfig displayConfig;

    public PhotoBrowseAdapter(Activity mActivity, List<String> imageList) {
        super();
        this.mActivity = mActivity;
        this.imageList = imageList;
        inflate=LayoutInflater.from(mActivity);
        // 获取应用程序最大可用内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        FileUtils fileUtils=new FileUtils(mActivity, "jereh");
        utils=new BitmapUtils(mActivity,fileUtils.getCacheDir(),cacheSize);
        displayConfig=new BitmapDisplayConfig();
        //displayConfig.setShowOriginal(true); // 显示原始图片,不压缩, 尽量不要使用, 图片太大时容易OOM。
        //utils.configDefaultBitmapMaxSize(BitmapCommonUtils.getScreenSize(mActivity));
        displayConfig.setBitmapMaxSize(BitmapCommonUtils.getScreenSize(mActivity));
        AlphaAnimation animation=new AlphaAnimation(0.1f,1.0f);
        animation.setDuration(500);
        displayConfig.setAnimation(animation);


    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0==arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv=new ImageView(container.getContext());
        utils.display(iv,imageList.get(0),displayConfig);
        container.addView(iv);
        return iv;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
