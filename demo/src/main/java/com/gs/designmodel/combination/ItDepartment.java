package com.gs.designmodel.combination;

/**
 * @author: Gaos
 * @Date: 2023-08-11 09:58
 *
 * 叶子节点
 * 也就是单个对象，需要注意的是我们要合理处理那些叶子节点不支持的接口方法
 **/
public class ItDepartment extends OrganizationComponent{
    public ItDepartment(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent organization) {
        throw new RuntimeException(this.getName() + "已是最下级部门，无法增加下属部门");
    }

    @Override
    public OrganizationComponent getChild(String orgName) {
        return getName().equals(orgName) ? this : null;
    }

    @Override
    public int getStaffCount() {
        return 20;
    }
}