package com.gs.dao.audit;

import lombok.Data;

/**
 * @User远
 * @Date2022/4/24
 */
@Data
public class AuditMemberDTO extends AuditDO {
    private String memberName;
    private String ip;
    private String port;
    private String displayStatus;
}
