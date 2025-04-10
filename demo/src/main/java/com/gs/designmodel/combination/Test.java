package com.gs.designmodel.combination;

/**
 * @author: Gaos
 * @Date: 2023-08-11 10:01
 **/
public class Test {


    public static void main(String[] args) {
        // 总部
        OrganizationComposite head = new OrganizationComposite("总公司");
        HrDepartment headHr = new HrDepartment("总公司行政部");
        ItDepartment headIt = new ItDepartment("总公司IT部");
        head.add(headIt);
        head.add(headHr);

        // 分公司
        OrganizationComposite branch = new OrganizationComposite("天津分公司");
        HrDepartment branchHr = new HrDepartment("天津分公司行政部");
        ItDepartment branchIt = new ItDepartment("天津分公司IT部");
        branch.add(branchIt);
        branch.add(branchHr);

        // 将分公司加到总部
        head.add(branch);

        System.out.println(head.getName() + "共有" + head.getStaffCount() + "名员工");

        OrganizationComponent item = head.getChild("天津分公司行政部");
        System.out.println(item.getName() + "共有" + item.getStaffCount() + "名员工");
    }
}