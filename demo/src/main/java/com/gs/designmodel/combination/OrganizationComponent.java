package com.gs.designmodel.combination;

/**
 * @author: Gaos
 * @Date: 2023-08-11 09:48
 *
 * 设置一个个体与组合通用的接口
 * 用来定义对外展示的统一处理接口
 **/
public abstract class OrganizationComponent {

    private String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void  add(OrganizationComponent organization);

    public abstract OrganizationComponent getChild(String orgName);

    public abstract int getStaffCount();

    @Override
    public String toString() {
        return name;
    }
}