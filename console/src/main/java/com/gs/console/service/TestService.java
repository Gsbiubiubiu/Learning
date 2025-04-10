package com.gs.console.service;

import cn.hutool.core.stream.StreamUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gs.dao.test.TestDAO;
import com.gs.dao.test.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @User远
 * @Date2022/4/13
 */
@Service
public class TestService {

    @Autowired
    private TestDAO testDAO;

//    @PostConstruct
//    public void init(){
//        List<TestDO> select = testDAO.select(new HashMap<>());
//        System.out.println(select.toString());
//    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>(){{
            add("123");
            add("456");
        }};
        System.out.println(a);
        String s = JSONObject.toJSONString(a);
        System.out.println(s);
        List<String> strings = JSONObject.parseArray(s, String.class);
        System.out.println(strings);
//        String item = a.toString();
//        System.out.println(JSONArray.toJSONString(item));
//        String s = "[https://test.leadinsight.cn/back/provincial/file/00a03rcpk2u3ccqkg27thraek6dec7p1.pdf,https://test.leadinsight.cn/back/provincial/file/00a03rcpk2u3ccqkg27thraek6dec7p1.pdf]";
//        String s1 = JSONArray.toJSONString(s);
//        System.out.println(s1);
//        List<String> strings = JSONObject.parseArray(JSONObject.toJSONString(s), String.class);
//        //List<String> strings = Arrays.asList(item);
//        System.out.println(strings.toString());
//        System.out.println(a.toString());
    }
}
