package com.gs.console.controller.audit;

import com.gs.common.web.ResultUtil;
import com.gs.console.service.audit.AuditManagerService;
import com.gs.console.service.audit.AuditMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @User远
 * @Date2022/4/22
 */
@Slf4j
@RestController
@RequestMapping("learn/audit")
public class AuditAction {

    @Autowired
    private AuditManagerService auditService;
    @Autowired
    private AuditMemberService auditMemberService;

    @RequestMapping(path = "/getPage", method = RequestMethod.GET)
    public Object getPage(@Valid AuditParam.GetPage param) throws Exception {
        Object page = auditService.getPage(param);
        return ResultUtil.getSuccessResult(page, param);
    }

    @RequestMapping(path = "/apply", method = RequestMethod.POST)
    public Object apply(@Valid @RequestBody AuditParam.Apply param) throws Exception {
        auditService.apply(param);
        return ResultUtil.getSuccessResult(true, param);
    }

    @RequestMapping(path = "/receiveApply", method = RequestMethod.POST)
    public Object receiveApply(@Valid @RequestBody AuditParam.ReceiveApply param){
        auditService.receiveApply(param);
        return ResultUtil.getSuccessResult(true, param);
    }

    @RequestMapping(path = "/audit", method = RequestMethod.POST)
    public Object audit(@Valid @RequestBody AuditParam.Audit param) throws Exception {
        auditService.audit(param);
        return ResultUtil.getSuccessResult(true, param);
    }

    @RequestMapping(path = "/receiveAudit", method = RequestMethod.POST)
    public Object receiveAudit(@Valid @RequestBody AuditParam.ReceiveAudit param){
        auditService.receiveAudit(param);
        return ResultUtil.getSuccessResult(true, param);
    }

//    @RequestMapping(path = "/getUnRead", method = RequestMethod.POST)
//    public Object getUnRead(@Valid AuditParam.GetUnRead param){
//        return auditMemberService.getUnRead(param);
//    }
}
