package com.gs.console.service.audit;

import com.gs.console.controller.audit.AuditParam;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @User远
 * @Date2022/4/24
 */
@Service
public class AuditManagerService {

    @Autowired
    private AuditFactory auditFactory;

    public Object getPage(AuditParam.GetPage param) throws Exception {
        AuditService auditService = auditFactory.build(param.getAuditType());
        return auditService.getPage(param.getType(), param.getAuditType(), null, param);
    }

    public void apply(AuditParam.Apply param) throws Exception {
        AuditService auditService = auditFactory.build(param.getAuditType());
        auditService.apply(param.getParam(), param.getDesc());
    }

    public void receiveApply(AuditParam.ReceiveApply param){
        AuditService auditService = auditFactory.build(param.getAuditType());
        auditService.receiveApply(param.getParam(), param.getRemoteId(), param.getDesc());
    }

    public void audit(AuditParam.Audit param) throws Exception {
        AuditService auditService = auditFactory.build(param.getAuditType());
        auditService.audit(param.getId(), param.getOperate());
    }

    public void receiveAudit(AuditParam.ReceiveAudit param){
        AuditService auditService = auditFactory.build(param.getAuditType());
        auditService.receiveAudit(param.getRemoteId(), param.getOperate());
    }
}
