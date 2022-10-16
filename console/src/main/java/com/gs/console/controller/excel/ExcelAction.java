package com.gs.console.controller.excel;

import com.gs.common.web.ResultUtil;
import com.gs.console.controller.audit.AuditParam;
import com.gs.console.service.excel.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @User远
 * @Date2022/10/6
 */
@Slf4j
@RestController
@RequestMapping("learn/excel")
public class ExcelAction {

    @Autowired
    private ExcelService excelService;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public Object excelTest(@Valid ExcelParam.Test param, HttpServletResponse response) throws Exception {
        excelService.excelTest(param, response);
        return null;
    }
}
