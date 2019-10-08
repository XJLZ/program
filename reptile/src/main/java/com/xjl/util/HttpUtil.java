package com.xjl.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Component("httpUtil")
public class HttpUtil {

    private PoolingHttpClientConnectionManager manager;

    public HttpUtil() {
        this.manager =new PoolingHttpClientConnectionManager();
        //设置最大连接数
        manager.setMaxTotal(100);
        //设置主机最大连接数
        manager.setDefaultMaxPerRoute(10);
    }

    /**
     * 根据请求页面地址下载图片
     * @param url
     * @return
     */
    public String doGetHtml(String url){
        //获取httpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(manager).build();
        //创建httpGet请求对象，设置url地址
        HttpPost httpGet = new HttpPost(url);
        //设置请求信息
        httpGet.setConfig(getConfig());

        CloseableHttpResponse response = null;
        try {
            //使用httpGet发起请求，获取响应数据
            response = httpClient.execute(httpGet);
            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200){
                if (response.getEntity()!=null){
                    String content = EntityUtils.toString(response.getEntity(), "utf8");
                    return content;
                }else {
                    return "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public String doGetImage(String url, String pName){
        //获取httpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(manager).build();
        //创建httpGet请求对象，设置url地址
        HttpGet httpGet = new HttpGet(url);
        //设置请求信息
        httpGet.setConfig(getConfig());

        CloseableHttpResponse response = null;
        try {
            //使用httpGet发起请求，获取响应数据
            response = httpClient.execute(httpGet);
            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200){
                if (response.getEntity()!=null){
                    //下载图片
                    //获取图片后缀
                    String exName = url.substring(url.lastIndexOf("."));
                    String lastName = ".jpg";
                    //创建图片，重命名图片
                    String picName = UUID.randomUUID().toString().replace("-", "")+exName;

                    //下载图片
                    //声明OutputStream
                    File file = new File("C:\\Users\\root\\Desktop\\Photos\\cos\\" + pName + exName);
                    OutputStream os = new FileOutputStream(file);
                    response.getEntity().writeTo(os);
                    //返回图片名称
                    return picName;
                }else {
                    return "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }


    /**
     * 设置请求信息
     * @return
     */
    private RequestConfig getConfig() {
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(1000)         //数据传输的最长时间
                .setConnectTimeout(1000)        //创建链接的最长时间
                .setConnectionRequestTimeout(1000)  //获取链接的最长时间
                .build();
        return config;
    }
}
