package com.gs.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import sun.misc.Request;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @User远
 * @Date2022/4/18
 */
public class HttpUtils {
    private static CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final int connectTimeout = 3000;
    private static final int connectRequestTimeout = 30000;
    private static final int socketTimeout = 30000;

    private static RequestConfig config = RequestConfig.custom()
            .setConnectTimeout(connectTimeout)
            .setConnectionRequestTimeout(connectRequestTimeout)
            .setSocketTimeout(socketTimeout)
            .build();

    public static String execute(HttpRequestBase request) throws Exception{
        request.setConfig(config);
        try(CloseableHttpResponse response = httpClient.execute(request)) {
//            if(response.getStatusLine().getStatusCode() != 200){
//                throw new Exception("http请求异常");
//            }
            return StreamUtils.readToString(response.getEntity().getContent());
        }
    }

    public static String doGet(String url) throws Exception {
        HttpGet get = new HttpGet(url);
        return execute(get);
    }

    public static String doGet(String url, Map<String, Object> params) throws Exception {
        return doGet(buildGetUrl(url, buildQuery(params)));
    }

    private static String buildGetUrl(String urlStr, Object query) throws MalformedURLException {
        URL url = new URL(urlStr);
        if(StringUtils.isEmpty(url.getQuery())){
            if(urlStr.endsWith("?")){
                urlStr = urlStr + query;
            }else {
                urlStr = urlStr + "?" + query;
            }
        }else {
            if(urlStr.endsWith("&")){
                urlStr = urlStr + query;
            }else {
                urlStr = urlStr + "&" +query;
            }
        }
        return urlStr;
    }

    private static Object buildQuery(Map<String, Object> parameters) throws Exception {
        if(parameters == null || parameters.isEmpty()){
            return null;
        }
        StrBuilder sb = new StrBuilder();
        boolean hasParam = false;
        for(Map.Entry<String, Object> entry : parameters.entrySet()){
            if(hasParam){
                sb.append("&");
            }else {
                hasParam = true;
            }
            String value;
            if(entry.getValue() == null){
                continue;
            }
            if(entry.getValue() instanceof List){
                value = StringUtils.join((List)entry.getValue(), ",");
            }else {
                value = String.valueOf(entry.getValue());
            }
            sb.append(entry.getKey()).append("=").append(URLEncoder.encode(value, "UTF-8"));
        }
        return sb.toString();
    }

    public static String doPost(String url, Map<String, Object> params) throws Exception {
        return doPost(url, JSON.toJSONString(params));
    }

    public static String doPostWithNull(String url, Map<String, Object> params) throws Exception {
        return doPost(url, JSON.toJSONString(params, SerializerFeature.WriteMapNullValue));
    }

    public static String doPost(String url, String param) throws Exception {
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json");
        post.setEntity(new StringEntity(param, "utf-8"));
        return execute(post);
    }

    public static String doDelete(String url) throws Exception {
        HttpDelete delete = new HttpDelete(url);
        return execute(delete);
    }

    public static String doPut(String url, String param) throws Exception {
        HttpPut httpPut = new HttpPut(url);
        httpPut.addHeader("Content-Type", "application/json");
        httpPut.setEntity(new StringEntity(param, HTTP.UTF_8));
        return execute(httpPut);
    }



}
