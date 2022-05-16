package com.gs.console.service.audit;

import com.gs.common.web.PageParam;
import com.gs.dao.audit.AuditDO;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @User远
 * @Date2022/4/24
 */
@Service
public class AuditDatasetService extends AuditService{
    @Override
    public void apply(Map<String, Object> param, String desc) throws Exception {

    }

    @Override
    public void receiveApply(Map<String, Object> param, Long remoteId, String desc) {

    }

    @Override
    public void audit(Long id, Integer operate) throws Exception {

    }

    @Override
    public void receiveAudit(Long remoteId, Integer operate) {

    }

    @Override
    public Long add(AuditDO auditDO) {
        return null;
    }

    @Override
    public Object getPage(Integer type, Integer auditType, Map<String, Object> param, PageParam pageParam) throws Exception {
        return null;
    }
}
