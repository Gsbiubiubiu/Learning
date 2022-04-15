package com.gs.console.controller.test;

import com.gs.console.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    @RequestMapping(path = "/getTest", method = RequestMethod.GET)
    public Object getTest(@Valid TestParam.GetTest param) {
        return null;
    }
}
