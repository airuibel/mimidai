//package com.mimidai.TestDemo;
//
//import com.aliyun.ots.thirdparty.org.apache.client.entity.UrlEncodedFormEntity;
//import com.aliyun.ots.thirdparty.org.apache.message.BasicNameValuePair;
//import com.mimidai.PhoneContactsMerge;
//import org.apache.http.HttpEntity;
//import org.apache.http.ParseException;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.stereotype.Repository;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
///**
// * Created by zhangyu on 2017/8/18.
// */
//@SpringBootApplication
//@Repository
//public class Hbase2LocalHost implements InitializingBean{
//
//    public static void main(String[] args) {
//        SpringApplication.run(Hbase2LocalHost.class, args);
//    }
//
//
//    public void get() {
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        try {
//            // 创建httpget.
//            HttpGet httpget = new HttpGet("http://www.baidu.com/");
//            System.out.println("executing request " + httpget.getURI());
//            // 执行get请求.
//            CloseableHttpResponse response = httpclient.execute(httpget);
//            try {
//                // 获取响应实体
//                HttpEntity entity = response.getEntity();
//                System.out.println("--------------------------------------");
//                // 打印响应状态
//                System.out.println(response.getStatusLine());
//                if (entity != null) {
//                    // 打印响应内容长度
//                    System.out.println("Response content length: " + entity.getContentLength());
//                    // 打印响应内容
//                    System.out.println("Response content: " + EntityUtils.toString(entity));
//                }
//                System.out.println("------------------------------------");
//            } finally {
//                response.close();
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭连接,释放资源
//            try {
//                httpclient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        get();
//    }
//}
