package com.gs.designmodel.chainofduty.bad;

/**
 * @author: Gaos
 * @Date: 2023-08-28 20:19
 **/
public class Test {

    public static void main(String[] args) {
        PreparationList preparationList = new PreparationList();
        if(preparationList.isWashHair()) {
            System.out.println("洗头");
        }
        if(preparationList.isWashFace()) {
            System.out.println("洗脸");
        }
        if(preparationList.isHaveBreakfast()) {
            System.out.println("吃早饭");
        }
        System.out.println("任务完成");
    }
}