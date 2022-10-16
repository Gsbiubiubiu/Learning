package com.gs.juc;

/**
 * @User远
 * @Date2022/3/1
 */

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 确保所有人走完之后 拿着钥匙的人(better man)才会锁门
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
//        failTestOne();
//        successfulCountDownLatch();
        //test();

//        Map<Integer, String> map = new TreeMap<>();
//        map.put(1, "double");
//        map.put(3, "int");
//        map.put(2, "string");
//        map.put(21, "string");
//        map.put(10, "string");
//        System.out.println(map);
        int[] data = new int[100];
        for (int i = 0; i < 100; i++) {
            data[i] = i;
        }
        CountDownLatch countDownLatch = new CountDownLatch(10);
        AtomicInteger num = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + data[finalI*10+j]);
                    num.addAndGet(1);
                }
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("总次数"+ num.toString());

    }

    /**
     *  eg: CountDownLatch主要有两个方法， 当一个或多个线程调用await方法时，这些线程会阻塞
     *  其他线程调用countDown()方法会将计数器减1 （调用countDown()方法时不会阻塞）
     *  当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行
     *
     * @throws InterruptedException
     */
    private static void successfulCountDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t离开房间");
                countDownLatch.countDown();
                System.out.println("count"+countDownLatch.getCount());
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("better man锁上了门");
    }


    private static void failTestOne() {
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t离开房间");
            }, String.valueOf(i)).start();
        }
        System.out.println(Thread.currentThread().getName()+" better man锁门");
    }

    private static void test() {
        List<Set<String>> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                Set<String> set = new HashSet();
                for (int j = 0; j < 10; j++) {
                    set.add(String.valueOf(j));
                }
                list.add(set);
                //System.out.println(Thread.currentThread().getName()+"\t离开房间");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < list.size(); i++) {
            Set<String> strings = list.get(i);
            System.out.println(strings);
        }
    }
}
