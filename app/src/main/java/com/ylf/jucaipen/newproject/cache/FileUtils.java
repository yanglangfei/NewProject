package com.ylf.jucaipen.newproject.cache;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.content.Context;
/**
 * 图片文件缓存
 *
 *
 */
public class FileUtils {

    /** 缓存文件目录 */
    private File mCacheDir;

    /**
     * 创建缓存文件目录，如果有SD卡，则使用SD，如果没有则使用系统自带缓存目录
     *
     * @param context
     * @param cacheDir 图片缓存的一级目录
     * @param dir
     */
    public FileUtils(Context context, String cacheDir){
        //Find the dir to save cached images
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            mCacheDir = new File(cacheDir);
        else
            mCacheDir = context.getCacheDir();// 如何获取系统内置的缓存存储路径
        if(!mCacheDir.exists())
            mCacheDir.mkdirs();
    }

    public String getCacheDir(){
        return mCacheDir.getAbsolutePath();

    }


}