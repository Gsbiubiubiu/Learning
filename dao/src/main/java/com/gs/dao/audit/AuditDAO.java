package com.gs.dao.audit;

import com.gs.dao.CRUD;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditDAO extends CRUD<AuditDO> {
}
