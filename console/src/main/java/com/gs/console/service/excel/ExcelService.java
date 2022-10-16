package com.gs.console.service.excel;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.gs.console.controller.excel.ExcelParam;
import com.gs.dao.excel.ExcelDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @User远
 * @Date2022/10/6
 */
@Service
@Slf4j
public class ExcelService {



    public void excelTest(ExcelParam.Test param, HttpServletResponse response) throws IOException {
        //写入Excel表
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //导入模版



//        FileInputStream fileInputStream = new FileInputStream("F:\\secsmart\\桌面\\test.xls");

        InputStream inputStreams = this.getClass().getClassLoader().getResourceAsStream("static/test.xls");
//        WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
//        writeSheet.setSheetName("successful");
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).withTemplate(inputStreams).excelType(ExcelTypeEnum.XLS).build();
        //定义sheet

//        writeSheet.setSheetNo(1);
//        String sheetName = writeSheet.getSheetName();
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "aaa").build();
//        System.out.println(sheetName);
        //添加参数 insuredsRequest（List集合）
        List<ExcelDo> list = new ArrayList<>();
        ExcelDo excelDO = new ExcelDo("张三", 3, 3, 3, 3);
//        excelDO.setValue("123");
//        ExcelDo excelDO2 = new ExcelDo("李四", 3, 3, 3, 3);
        list.add(excelDO);
//        list.add(excelDO2);
        String fileName = "nihao.xls";
        try{
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(list,fillConfig, writeSheet);
            response.setContentType("application/xls");
            response.setHeader("Location", URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
        }finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }

//        InputStream inputStream1 = streamTran(outputStream);
//        try {
//            this.setResponseHeader(response, 1 + "年第" + 1 + "期项目认定查处情况综合统计" + ".xls");
//            os.flush();
//            os.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 发送响应流方法
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


