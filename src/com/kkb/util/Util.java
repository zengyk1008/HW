package com.kkb.util;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Util {
    /**
     *读取网址数据
     * @booth
     */
    public static String getString(String url) {
        //1、创建一个网址 抽象表示（对象）
        try {
            URL u = new URL(url);
            //2、打开链接
            URLConnection conn = u.openConnection();
            //3、获取传输数据通道
            InputStream is = conn.getInputStream();
            //4、将字节输入流，装饰为能一次读取一行文字的缓冲字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
            //5、读取一行行的数据
            StringBuffer sb = new StringBuffer();
            String text = null;
            while ((text = br.readLine()) != null) {
                sb.append(text);
            }
            //6、将读取的数去返回给调用者
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
     //获取天气
    public static void main(String[]args) {
        String json = getString("https://itdage.cn/hw/weather?city=%E5%8C%97%E4%BA%AC");
        System.out.println(json);
    }}

     */

    //获取短信
    public static String getWeather(String city) {
        try {
            String json1 = getString("https://itdage.cn/hw/weather?city="+ URLEncoder.encode(city,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String sendSms(String name, String phoneNumber, String s1, String s2,String s3){
        try {
            name = URLEncoder.encode(name,"utf-8");
            s1 = URLEncoder.encode(s1,"utf-8");
            s3 = URLEncoder.encode(s3,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String json1 = getString("https://itdage.cn/hw/hwSms?name="+name+"&phoneNumber="+phoneNumber+"&s1="+s1+"&s2="+s2+"&s3="+s3);
        System.out.println(json1);
        return json1;
    }


    public static void main(String[]args) throws UnsupportedEncodingException {
        //String city = "北京";
        String name = "小黑";
        String phoneNumber = "13678917461";
        //String phoneNumber = "18318460995";
        String s1 = "晴";
        String s2 = "30-35";
        String s3 = "电视剧好看不？？？";
        sendSms(name,phoneNumber,s1,s2,s3);
}}

