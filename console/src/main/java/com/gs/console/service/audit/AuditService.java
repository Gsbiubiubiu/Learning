package com.gs.console.service.audit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gs.common.Constant;
import com.gs.common.utils.HttpUtils;
import com.gs.common.utils.MapUtils;
import com.gs.common.web.ApiResult;
import com.gs.common.web.PageParam;
import com.gs.console.constant.AuditType;
import com.gs.console.controller.audit.AuditParam;
import com.gs.dao.audit.AuditDAO;
import com.gs.dao.audit.AuditDO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @User远
 * @Date2022/4/24
 */
@Service
@Slf4j
public abstract class AuditService {

    @Autowired
    private AuditDAO auditDAO;

    public static Integer Un_Audit_Type = 0;
    public static Integer Audit_Record_Type = 1;
    public static Integer Apply_Record_Type = 2;

    public static Integer Agree_Operate = 0;
    public static Integer Refuse_Operate = 1;

    public abstract void apply(Map<String, Object> param, String desc) throws Exception;

    public abstract void receiveApply(Map<String, Object> param, Long remoteId, String desc);

    public abstract void audit(Long id, Integer operate) throws Exception;

    public abstract void receiveAudit(Long remoteId, Integer operate);

    public abstract Long add(AuditDO auditDO);

    public abstract Object getPage(Integer type, Integer auditType, Map<String, Object> param, PageParam pageParam) throws Exception;

    public void sendApply(Map<String, Object> remoteParam, String ip, String port) throws Exception {
        String url = String.format("http://%s:%s/learn/audit/receiveApply", ip, port);
        String result = HttpUtils.doPost(url, remoteParam);
        ApiResult<Object> parse = JSON.parseObject(result, new TypeReference<ApiResult<Object>>() {
        });

        if(parse.getStatus() == ApiResult.Failed){
            log.error("Failed to apply resource from partner, type{}, error{}", AuditType.Dataset.getDesc(), parse.getError());
            throw new RuntimeException("申请失败， 稍后再试");
        }
    }

    public void sendAudit(Map<String, Object> remoteParam, String ip, String port, Long id, Integer operate) throws Exception{
        String url = String.format("http://%s:%s/learn/audit/receiveAudit", ip, port);
        String result = HttpUtils.doPost(url, remoteParam);
        ApiResult<Object> parse = JSON.parseObject(result, new TypeReference<ApiResult<Object>>() {
        });
        if(parse.getStatus() == ApiResult.Failed){
            log.error("Failed to apply resource from partner, type{}, error{}", AuditType.Dataset.getDesc(), parse.getError());
            throw new RuntimeException("通知审核结果失败， 稍后再试");
        }else if(parse.getStatus() == ApiResult.Success){
            if(operate.equals(Agree_Operate)){
                updateStatus(id, AuditDO.Agree, Constant.FAKE_USER_ID);
            }else if(operate.equals(Refuse_Operate)){
                updateStatus(id, AuditDO.Refuse, Constant.FAKE_USER_ID);
            }
        }
    }

    public void updateStatus(Long id, Integer status, Long modifyUserId){
        auditDAO.update(MapUtils.create(
                "id", id,
                "status", status,
                "modifyUserId", modifyUserId
        ));
    }

    public Map<String, Object> getConds(Integer type, Integer auditType, Map<String, Object> param){
        Map<String, Object> conds = param == null ? new HashMap<>() : new HashMap<>(param);
        conds.put("auditType", auditType);
        if(Un_Audit_Type.equals(type)){
            conds.put("type", AuditDO.Receive_Type);
            conds.put("status", AuditDO.Need_Audit);
        }else if(Audit_Record_Type.equals(type)){
            conds.put("type", AuditDO.Receive_Type);
            List<Integer> list = new ArrayList<>();
            list.add(AuditDO.Agree);
            list.add(AuditDO.Refuse);
            conds.put("statues", list);
        }else if(Apply_Record_Type.equals(type)){
            conds.put("type", AuditDO.Send_Type);
        }
        return conds;
    }

}
