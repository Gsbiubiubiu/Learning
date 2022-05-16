package com.gs.dao.message;

import com.gs.dao.BaseDO;
import jdk.net.SocketFlow;
import lombok.Data;

/**
 * @User远
 * @Date2022/4/24
 */
@Data
public class MessageDO extends BaseDO {
    public static Integer Unread_Status = 0;
    public static Integer Read_Status = 1;

    public static Integer NO_AUDIT_TYPE = -1;
    public static Integer Member_Type = 1;
    public static Integer Dataset_Type = 2;

    private Long id;
    private String message;
    private Integer status;
    private Integer type;
    private String params;
}
