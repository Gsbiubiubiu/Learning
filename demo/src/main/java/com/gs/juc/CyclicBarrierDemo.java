package com.gs.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @User远
 * @Date2022/3/1
 */
public class CyclicBarrierDemo {

    /**
     * 人全部到齐后 再开门
     * @param args
     */
    public static void main(String[] args) {
        successfulTest();
        Integer a = 100;
        Integer b = 100;
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }

    private static void successfulTest() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()->{
            System.out.println("开门");
        });
        for (int i = 0; i < 7; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 第"+ finalI +"个人到现场");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
