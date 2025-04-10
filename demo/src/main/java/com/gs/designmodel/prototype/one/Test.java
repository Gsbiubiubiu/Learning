package com.gs.designmodel.prototype.one;

/**
 * @author: Gaos
 * @Date: 2023-07-21 14:30
 **/
public class Test {
    public static void main(String[] args) {
        Realizetype realizetypeOne = new Realizetype();
        Realizetype realizetypeClone = realizetypeOne.clone();

        System.out.println(realizetypeOne == realizetypeClone);
    }
}