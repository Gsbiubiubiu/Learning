package com.gs.console.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gs.common.utils.DESUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @User远
 * @Date2022/4/26
 */
@Slf4j
public class MyFilter extends OncePerRequestFilter {

    private static final String s = "A1B2C3D4E5F60708";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = httpServletRequest.getRequestURI();
        log.info("请求路径{}", requestURI);
        String method = httpServletRequest.getMethod();
        if(method.equals("POST")){
            MyRequestWrapper requestWrapper = new MyRequestWrapper(httpServletRequest);
            MyResponseWrapper responseWrapper  = new MyResponseWrapper(httpServletResponse);
            String body = requestWrapper.getBody();
            String decrypt = null;
            try {
                decrypt = DESUtil.decrypt(body.toString(), s);
            } catch (Exception e) {
                log.error("", e);
            }
//            JSONObject jsonObject = JSONObject.parseObject(body);
//            Object data = jsonObject.get("data");


            requestWrapper.setBody(decrypt);
            filterChain.doFilter(requestWrapper,responseWrapper);
            byte[] responseData = responseWrapper.getResponseData();
            String encrypt = new String(responseData);
            try {
                encrypt = DESUtil.encrypt(new String(responseData), s);
            } catch (Exception e) {
                log.error("", e);
            }
            writeResponse(httpServletResponse,httpServletResponse.getStatus(),encrypt);
//            byte[] responseData = responseWrapper.getResponseData();
//            String encrypt = null;
//            try {
//                encrypt = DESUtil.encrypt(new String(responseData), s);
//            } catch (Exception e) {
//                log.error("", e);
//            }
//            ServletOutputStream out = responseWrapper.getOutputStream();
//            out.write(encrypt.getBytes());
//            out.flush();
//            PrintWriter out = responseWrapper.getWriter();
//            out.print(encrypt);
//            out.flush();
//            out.close();
        }
    }
    //写回到response
    public static void writeResponse(HttpServletResponse response, int status, String json) {
        try {
            //之前有被拦截器处理过的response，走到这里后会界面显示500
            //这个是必须的
            response.reset();//很重要
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(status);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class HttpResponseUtil {
        public void output(HttpServletResponse response, Object message) {
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("expose_headers", "['Authorization']");
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.write(JSON.toJSONString(message, SerializerFeature.WriteMapNullValue));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
