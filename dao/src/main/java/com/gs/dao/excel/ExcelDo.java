package com.gs.dao.excel;

import com.gs.dao.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @User远
 * @Date2022/10/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelDo {
    private String nameList;
    private Integer value;
    private Integer codeList;

    // 扰动图斑现场核查情况（个）
    private Integer spotFrom;
    private Integer spotNoChecks;


}
