package com.gs.everything.base.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Gaos
 * @Date: 2023-02-21 10:53
 **/
public class Test {


    private void test() {
        new Thread(()-> System.out.println("啦啦啦")).start();
    }


    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "test1");
        map.put(2, "test2");
        map.put(3, "test3");

        map.forEach((x, y) -> {
            System.out.println(x);
            System.out.println(y);
        });
    }



}