package com.gs.common.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @User远
 * @Date2022/4/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> implements Serializable {
    //TODO 序列化反序列化  一般实体类都会实现 序列化接口用来rpc调用 但其实json用的比较多 还有存储文件
    private static final long serialVersionUID = -6629012681534400264L;

    public static final int Success = 0;
    public static final int Failed = 1;

    private int status;
    private T data;
    private String error;

    public static <T> ApiResult<T> getSuccess(T data) {
        return new ApiResult<>(0, data, null);
    }

    public static <T> ApiResult<T> getSuccess(T data, String message){
        return new ApiResult<>(0, data, message);
    }

    public static <T> ApiResult<T> getFailed(String message){
        return new ApiResult<>(1, null, message);
    }
}
