package com.gs.console.controller.test;

import com.alibaba.fastjson.JSON;
import com.gs.common.utils.DESUtil;
import com.gs.common.utils.MapUtils;
import com.gs.common.web.ResultUtil;
import com.gs.console.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * @User远
 * @Date2022/4/13
 */
@Slf4j
@RestController
@RequestMapping("learn/test")
public class TestAction {

    @Autowired
    private TestService testService;

    @RequestMapping(path = "/getTest", method = RequestMethod.POST)
    public Object getTest(@Valid @RequestBody TestParam.GetTest param)
    {
        String data = "啦啦啦啦啦啦";
        return ResultUtil.getSuccessResult(data, param);
    }

    public static void main(String[] args) throws Exception {
        String s = "A1B2C3D4E5F60708";
//        Map<String, Object> map = MapUtils.create("testName", "gs",
//                "port", "1234");
//        String url = "http://localhost:8888/learn/test/getTest";
//        String string = JSON.toJSONString(map);
//        String encrypt = DESUtil.encrypt(string, s);
////        System.out.println(encrypt);
        String s1 = "J65VeCu3Of55eoKoDyoa8vJjBVFtr47UOnrLf6Gp6oCF/DniFhAv8paBffnK+h5S";
        String decrypt = DESUtil.decrypt(s1, s);
        System.out.println(decrypt);
    }
}
