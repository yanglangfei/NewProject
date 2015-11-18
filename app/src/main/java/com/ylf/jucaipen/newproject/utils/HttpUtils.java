package com.ylf.jucaipen.newproject.utils;

import com.ylf.jucaipen.newproject.been.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2015/11/17.
 */
public class HttpUtils {

    public String  sendPost(String path,Object params){
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;
        HttpURLConnection con = null;
        ObjectOutputStream oos = null;
        try {
            URL url=new URL(path);
            con= (HttpURLConnection) url.openConnection();
            // 设置允许输出，默认为false
            con.setDoOutput(true);
            con.setConnectTimeout(5 * 1000);
            con.setReadTimeout(10 * 1000);
            // 请求方式为POST请求
            con.setRequestMethod("POST");
            oos=new ObjectOutputStream(con.getOutputStream());
            // 向服务端写数据
            oos.writeObject(params);
            // 获得服务端的返回数据
            InputStreamReader read = new InputStreamReader(
                    con.getInputStream());
            reader = new BufferedReader(read);
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }catch (Exception e){

        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                con.disconnect();
            }
        }
        return  sb.toString();
    }
}
