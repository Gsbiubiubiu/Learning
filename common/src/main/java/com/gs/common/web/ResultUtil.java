package com.gs.common.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @User远
 * @Date2022/4/8
 */
//TODO 待看
public class ResultUtil {
    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private static String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\\\]";
    private static Pattern compile = Pattern.compile(regEx);

    /**
     * 根据请求参数和响应结果构造
     *
     */

    public static Object getSuccessResult(Object data, CallbackParam param) {
        judgeCallBackParam(param);
        // 返回json格式
        if(param != null && StringUtils.isNotBlank(param.getCallback())){
            return returnJSONPString(param, returnJSONString(ApiResult.getSuccess(data), null));
        }
        return returnJSONString(ApiResult.getSuccess(data), null);
    }

    /**
     *
     * 根据请求参数和相应结果构造
     *
     */
    public static Object getSuccessResult(Object data, String msg, CallbackParam param) {
        judgeCallBackParam(param);
        // 返回json格式
        if(param != null && StringUtils.isNotBlank(param.getCallback())){
            return returnJSONPString(param, returnJSONString(ApiResult.getSuccess(data, msg), null));
        }
        return returnJSONString(ApiResult.getSuccess(data, msg), null);
    }

    public static Object getSuccessResultWithDateFormat(Object data, CallbackParam param, String format){
        judgeCallBackParam(param);
        if(param != null && StringUtils.isNotBlank(param.getCallback())){
            return returnJSONPString(param, returnJSONString(ApiResult.getSuccess(data), format));
        }
        return returnJSONString(ApiResult.getSuccess(data), format);
    }

    public static Object getFailedResult(String msg, CallbackParam param){
        judgeCallBackParam(param);
        if(param != null && StringUtils.isNotBlank(param.getCallback())){
            return returnJSONPString(param, returnJSONString(ApiResult.getFailed(msg), null));
        }
        return returnJSONString(ApiResult.getFailed(msg), null);
    }

    private static String returnJSONString(ApiResult result, String format){
        if(StringUtils.isNotBlank(format)){
            return JSON.toJSONStringWithDateFormat(result, YYYY_MM_DD_HH_MM_SS,
                    SerializerFeature.WriteDateUseDateFormat,
                    SerializerFeature.DisableCircularReferenceDetect,
                    SerializerFeature.WriteNonStringKeyAsString);
        }else {
            return JSON.toJSONStringWithDateFormat(result, format,
                    SerializerFeature.WriteDateUseDateFormat,
                    SerializerFeature.DisableCircularReferenceDetect,
                    SerializerFeature.WriteNonStringKeyAsString);
        }
    }

    private static Object returnJSONPString(CallbackParam param, String jsonString) {
        StringBuilder sb = new StringBuilder(64);
        if(param != null && StringUtils.isNotBlank(param.getScriptWrapping())){
            sb.append("<script>");
            if(StringUtils.isNotBlank(param.getCallback())){
                sb.append(param.getCallback()).append("(").append(jsonString).append(")");
            }else {
                sb.append(jsonString);
            }
            sb.append("</script>");
            return sb.toString();
        }
        if(param != null && StringUtils.isNotBlank(param.getCallback())){
            sb.append(param.getCallback()).append("(").append(jsonString).append(")");
            return sb.toString();
        }
        return sb;
    }

    private static void judgeCallBackParam(CallbackParam param){
        if (null != param) {
            String callback = param.getCallback();
            if(StringUtils.isNotBlank(callback)){
                Matcher matcher = compile.matcher(callback);
                String result = matcher.replaceAll("%");
                param.setCallback(result);
            }
        }
    }

}
