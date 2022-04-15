package com.gs.console.controller.test;

import com.gs.common.web.CallbackParam;
import lombok.Data;

import javax.validation.constraints.NotBlank;

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
}
