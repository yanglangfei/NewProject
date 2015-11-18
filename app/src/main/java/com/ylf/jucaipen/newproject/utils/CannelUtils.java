package com.ylf.jucaipen.newproject.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2015/11/18.
 */
public class CannelUtils {

    /**
     * @param context
     * @param key
     * @return   从清单文件中的 metadate 标签中获取发布渠道信息
     */
    public static  String getMetaData(Context context,String key){
        try {
            ApplicationInfo info=context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            String values=info.metaData.getString(key);
            return  values;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
