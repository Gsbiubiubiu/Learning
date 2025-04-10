package com.gs.designmodel.visitor;

/**
 * @author: Gaos
 * @Date: 2023-08-25 11:52
 **/
public class Test {
    public static void main(String[] args) {
        MisCompany misCompany = new MisCompany();

        // 你可以随意切换visitor，但前提是你的ObjectStructure结构稳定
        System.out.println("--------启动社交app项目");
        misCompany.startProject(new SocialApp());

        System.out.println("--------启动短视频app项目");
        misCompany.startProject(new LiveApp());
    }
}