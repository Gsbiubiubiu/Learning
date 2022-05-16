package com.gs.dao.audit;

import com.gs.dao.BaseDO;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @User远
 * @Date2022/4/24
 */

@Data
public class AuditDO extends BaseDO {

    public static Integer Send_Type = 0;
    public static Integer Receive_Type = 1;

    public static Integer Need_Audit = 0;
    public static Integer Agree = 1;
    public static Integer Refuse = 2;

    private Long id;
    private Long memberId;
    private Long remoteId;
    private Integer type;
    private Integer auditType;
    private Integer status;
    private String desc;
    private String param;

    public final static Map<Integer, String> auditStaticMap = new HashMap<Integer, String>(){{
        put(Need_Audit, "待审核");
        put(Agree, "已通过");
        put(Refuse, "已拒绝");
    }};

    public AuditDO() {
    }

    public AuditDO(Long memberId, Long remoteId, Integer type, Integer status, String desc, String param) {
        this.memberId = memberId;
        this.remoteId = remoteId;
        this.type = type;
        this.status = status;
        this.desc = desc;
        this.param = param;
    }

    public AuditDO(Long memberId, Integer type, Integer status, String desc, String param) {
        this.memberId = memberId;
        this.type = type;
        this.status = status;
        this.desc = desc;
        this.param = param;
    }
}
