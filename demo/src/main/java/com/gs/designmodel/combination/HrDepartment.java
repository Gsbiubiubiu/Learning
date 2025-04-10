package com.gs.designmodel.combination;

/**
 * @author: Gaos
 * @Date: 2023-08-11 10:08
 **/
public class HrDepartment extends OrganizationComponent{
    public HrDepartment(String name) {
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
        return 5;
    }
}