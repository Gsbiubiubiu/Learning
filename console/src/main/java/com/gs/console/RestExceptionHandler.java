package com.gs.console;

import com.alibaba.fastjson.JSON;
import com.gs.common.web.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

/**
 * @User远
 * @Date2022/4/18
 */

@ControllerAdvice
@Slf4j
@ResponseBody
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("url:{}, {}", request.getRequestURI(), JSON.toJSONString(request.getParameterMap()));
        log.error(ExceptionUtils.getStackTrace(e));
        FieldError fieldError = e.getBindingResult().getFieldError();
        String error = null;
        if(fieldError != null){
            error = fieldError.getDefaultMessage();
        }
        return ResultUtil.getFailedResult("参数异常" + error, null);
    }

    @ExceptionHandler(BindException.class)
    public Object bindException(BindException e, HttpServletRequest request){
        log.error("url:{}, {}", request.getRequestURI(), JSON.toJSONString(request.getParameterMap()));
        log.error(ExceptionUtils.getStackTrace(e));
        String error = e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
        return ResultUtil.getFailedResult("参数异常" + error, null);
    }

    @ExceptionHandler(UnsupportedEncodingException.class)
    public Object encodingException(UnsupportedEncodingException e, HttpServletRequest request){
        log.error("url:{}, {}", request.getRequestURI(), JSON.toJSONString(request.getParameterMap()));
        log.error(ExceptionUtils.getStackTrace(e));
        return ResultUtil.getFailedResult("编码异常" + e.getMessage(), null);
    }

    @ExceptionHandler(IOException.class)
    public Object ioException(IOException e, HttpServletRequest request){
        log.error("url:{}, {}", request.getRequestURI(), JSON.toJSONString(request.getParameterMap()));
        log.error(ExceptionUtils.getStackTrace(e));
        return ResultUtil.getFailedResult("IO异常" + e.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public Object otherException(Exception e, HttpServletRequest request){
        log.error("url:{}, {}", request.getRequestURI(), JSON.toJSONString(request.getParameterMap()));
        log.error(ExceptionUtils.getStackTrace(e));
        return ResultUtil.getFailedResult("异常" + e.getMessage(), null);
    }
}
