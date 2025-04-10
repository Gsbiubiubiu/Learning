package com.gs.designmodel.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-08-11 09:51
 *
 * 组合类
 * 此类持有一个List<OrganizationComponent> 并继承OrganizationComponent
 **/
public class OrganizationComposite extends OrganizationComponent{

    private List<OrganizationComponent> organizations = new ArrayList<>();

    public OrganizationComposite(String name) {
        super(name);
    }



    @Override
    public void add(OrganizationComponent organization) {
        organizations.add(organization);
    }

    @Override
    public OrganizationComponent getChild(String orgName) {
        for (OrganizationComponent item : organizations) {
            OrganizationComponent child = item.getChild(orgName);
            if(child != null) {
                return child;
            }
        }
        return null;
    }

    @Override
    public int getStaffCount() {
        return organizations.stream().mapToInt(OrganizationComponent::getStaffCount).sum();
    }
}