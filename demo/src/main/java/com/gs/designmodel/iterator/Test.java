package com.gs.designmodel.iterator;

import java.util.Iterator;

/**
 * @author: Gaos
 * @Date: 2023-08-15 19:47
 **/
public class Test {
    public static void main(String[] args) {
        Class cls = new Class();
        Iterator<Student> iterator = cls.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 当然我们也可以使用foreach 它已经默认实现了
        for (Student item : cls) {
            System.out.println(item);
        }
    }
}