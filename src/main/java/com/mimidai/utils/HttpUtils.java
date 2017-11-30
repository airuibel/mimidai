package com.mimidai.utils;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/9/26.
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger("log.http.HttpUtils");
    /**
     * @Fields ENCODING : 编码格式。发送编码格式统一用UTF-8
     */
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    private static Gson gson = new Gson();


    /**
     * @Title: sentPost
     * @Description: post请求
     * @param url
     *            提交的URL
     * @param paramsMap
     *            提交<参数，值>Map
     * @return String 返回类型
     * @throws
     */
    public static String post(String url, Map<String, String> paramsMap) {
        if(url.indexOf("api.xinshucredit.com")>-1){

        }
        String responseText = "";
        CloseableHttpResponse response = null;
        try (CloseableHttpClient client = HttpClients.createDefault()){
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
                            param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, DEF_CHATSET));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(responseText.indexOf("未找到匹配的模板") != -1){
                logger.debug("http-POST请求：url={"+url+"} , result={"+responseText+"}");
                logger.warn("未找到模板的参数:"+paramsMap);
            }
            try {
                response.close();
            } catch (Exception e) {
                logger.error("response关闭出错",e);
            }
        }
        return responseText;
    }
}
