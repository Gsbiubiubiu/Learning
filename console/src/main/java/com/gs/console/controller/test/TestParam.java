package com.gs.console.controller.test;

import com.alibaba.fastjson.JSON;
import com.gs.common.utils.DESUtil;
import com.gs.common.utils.HttpUtils;
import com.gs.common.utils.MapUtils;
import com.gs.common.web.CallbackParam;
import lombok.Data;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Map;

/**
 * @User远
 * @Date2022/4/13
 */
public class TestParam {

    @Data
    public static class GetTest extends CallbackParam {

        @NotBlank(message = "测试名称不能为空")
        private String testName;
        @NotBlank(message = "测试端口不能为空")
        private String port;
    }

    public static void main(String[] args) throws Exception {
        String s = "A1B2C3D4E5F60708";
        Map<String, Object> map = MapUtils.create("testName", "gs",
                "port", "1234");
        String url = "http://localhost:8888/learn/test/getTest";
        String string = JSON.toJSONString(map);
        String encrypt = DESUtil.encrypt(string, s);
//        String s1 = HttpUtils.doPost(url, encrypt);
//        System.out.println("result" + s1);
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(encrypt, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            resultString = e.getMessage();
            System.out.println(resultString);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                System.out.println("response关闭失败");
            }
        }
        System.out.println(resultString);;
    }
}
