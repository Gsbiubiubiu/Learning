package com.gs.console.service.audit;

import com.gs.console.constant.AuditType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @User远
 * @Date2022/4/24
 */
@Service
@Slf4j
public class AuditFactory {

    @Autowired
    private AuditMemberService auditMemberService;

    @Autowired
    private AuditDatasetService auditDatasetService;

    public AuditService build(Integer code){
        AuditType type = AuditType.valueOf(code);
        switch (type) {
            case Member:
                return auditMemberService;
            case Dataset:
                return auditDatasetService;
            default:
                throw new RuntimeException("未知的类型");
        }
    }
}
