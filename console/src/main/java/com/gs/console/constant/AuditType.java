package com.gs.console.constant;

/**
 * @User远
 * @Date2022/4/24
 */
public enum AuditType {
    Member(0, "成员邀请", "member"),
    Dataset(1, "数据集授权", "dataset"),
    ;

    private Integer code;
    private String desc;
    private String enName;

    public static AuditType valueOf(Integer typeCode){
        if(typeCode == null){
            return null;
        }
        for(AuditType value : AuditType.values()){
            if(typeCode.equals(value.code)){
                return value;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getEnName() {
        return enName;
    }

    AuditType(Integer code, String desc, String enName) {
        this.code = code;
        this.desc = desc;
        this.enName = enName;
    }
}
