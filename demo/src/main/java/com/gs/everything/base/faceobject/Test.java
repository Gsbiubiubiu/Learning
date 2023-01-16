package com.gs.everything.base.faceobject;

/**
 * @author: Gaos
 * @Date: 2023-01-12 16:03
 **/
public class Test {
    public static void main(String[] args) {
        Zi zi = new Zi();

    }

    static class Fu {
        int a = 10;

        public void printA() {
            System.out.println("Fu PrintA:" + a);
        }

        public Fu() {
            printA();
        }
    }

    static class Zi extends Fu {
        int a = 20;

        @Override
        public void printA() {
            System.out.println("Zi PrintA:" + a);
        }

        public Zi() {
            printA();
        }
    }
}