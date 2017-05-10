package com.imooc.demo1.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pp on 2017/2/28.
 */
public class Demo1Tool {

    public static String doGet(String url,String cookieName,String cookieValue){
        StringBuffer sb = new StringBuffer();
        HttpURLConnection httpURLConnection = null;
        try {
            URL urls = new URL(url + "?cookieName=" + cookieName + "&cookieValue=" + cookieValue);
            httpURLConnection = (HttpURLConnection) urls.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = null;
            while ((temp = bufferedReader.readLine()) != null){
                sb.append(temp);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }
        return sb.toString();
    }
}
