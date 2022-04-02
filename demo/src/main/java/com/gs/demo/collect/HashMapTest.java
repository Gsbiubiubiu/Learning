package com.gs.demo.collect;

import java.util.HashMap;
import java.util.Map;

/**
 * @User远
 * @Date2022/3/29
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        String str1 = "hello";
        String str2 = "he"+ new String("llo");
        System.out.println(str1 == str2);

        if(true){
            System.out.println("1");
        }else if (true){
            System.out.println("2");
        }else {
            System.out.println("3");
        }
    }
}
