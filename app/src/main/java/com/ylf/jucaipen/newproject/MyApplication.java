package com.ylf.jucaipen.newproject;

import android.app.Application;
import android.view.WindowManager;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

/**
 * Created by Administrator on 2015/11/17.
 */
public class MyApplication extends Application {
    private  int screenWidth;
    private  int screenHeight;
    private static  MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        WindowManager wm= (WindowManager) this.getSystemService(WINDOW_SERVICE);
        screenHeight=wm.getDefaultDisplay().getHeight();
        screenWidth=wm.getDefaultDisplay().getWidth();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(screenWidth,screenHeight)//设置解析图片的大小，一般以手机屏幕大小为准
                .diskCacheExtraOptions(screenWidth,screenHeight,null)//保存到磁盘使用的大小以及压缩方法，默认原图保存
                .threadPoolSize(3)//线程池大小，不能太大，会出现OOM
                .threadPriority(Thread.NORM_PRIORITY-1) //设置线程的优先程度 5-1
                .tasksProcessingOrder(QueueProcessingType.FIFO)//设置图片加载和显示队列处理的类型 默认为QueueProcessingType.
               //  FIFO注:如果设置了taskExecutor或者taskExecutorForCachedImages 此设置无效
                .memoryCache(new LruMemoryCache(2*1024*1024))//设置内存缓存 默认为一个当前应用可用内存的1/8大小的
                .memoryCacheSize(2*1024*1014)//设置内存缓存的最大大小 默认为一个当前应用可用内存的1/8
                .memoryCacheSizePercentage(13)//设置内存缓存最大大小占当前应用可用内存的百分比 默认为一个当前应用可用内存的1/8
                .diskCache(new UnlimitedDiskCache(StorageUtils.getCacheDirectory(getApplicationContext())))//默认为StorageUtils.getCacheDirectory(getApplicationContext()),即/mnt/sdcard/android/data/包名/cache/
               .diskCacheSize(50*1024*1024) //设置硬盘缓存的最大大小
                .diskCacheFileCount(100) //设置硬盘缓存的文件的最多个数
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) //设置硬盘缓存文件名生成规范
                .imageDownloader(new BaseImageDownloader(this)) //设置图片下载器
                .imageDecoder(DefaultConfigurationFactory.createImageDecoder(false)) //设置图片的解析器
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) //设置默认的图片显示选项
                .denyCacheImageMultipleSizesInMemory()  //不缓存图片的多种尺寸在内存中
                .writeDebugLogs() //打印调试Log,注意上线之前要去掉这句话
                .imageDownloader(new BaseImageDownloader(this,5*1000,30*1000))  //图片下载器的设置  超时时间   读取时间
                .build();
                ImageLoader.getInstance().init(configuration);  //使用基本配置信息初始化ImageLoader

    }
    public  static MyApplication getInstance(){
        return  application;
    }
}
