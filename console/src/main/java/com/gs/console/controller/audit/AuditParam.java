package com.gs.console.controller.audit;

import com.gs.common.web.CallbackParam;
import com.gs.common.web.PageParam;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @User远
 * @Date2022/4/22
 */

public class AuditParam {

    @Data
    public static class GetPage extends PageParam {
        @NotNull(message = "页面类型不能为空")
        private Integer type;

        @NotNull(message = "审核类型不能为空")
        private Integer auditType;
    }

    @Data
    public static class Apply extends CallbackParam{
        @NotNull(message = "审核类型不能为空")
        private Integer auditType;
        private Map<String, Object> param;
        private String desc;
    }

    @Data
    public static class ReceiveApply extends CallbackParam{
        @NotNull(message = "审核类型不能为空")
        private Integer auditType;
        @NotNull(message = "申请方审核ID不能为空")
        private Long remoteId;
        private Map<String, Object> param;
        private String desc;
    }

    @Data
    public static class Audit extends CallbackParam{
        @NotNull(message = "审核类型不能为空")
        private Integer auditType;
        @NotNull(message = "消息id不能为空")
        private Long id;
        @NotNull(message = "操作类型不能为空")
        private Integer operate;
    }

    @Data
    public static class GetUnRead extends CallbackParam{
    }

    @Data
    public static class ReceiveAudit extends CallbackParam{
        @NotNull(message = "审核类型不能为空")
        private Integer auditType;
        @NotNull(message = "消息id不能为空")
        private Long remoteId;
        @NotNull(message = "操作类型不能为空")
        private Integer operate;
    }
}
