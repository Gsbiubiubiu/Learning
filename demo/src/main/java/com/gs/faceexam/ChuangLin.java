package com.gs.faceexam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @User远
 * @Date2022/9/1
 */
public class ChuangLin {
    public static void main(String[] args) throws InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//        // 最大值
//        int maxParse = scanner.nextInt();
//        scanner.nextLine();
//        String str = scanner.nextLine();
//        String[] prices = str.split(" ");
//        // int数组 排序
//        int[] priceArr = Arrays.stream(prices).mapToInt(Integer::parseInt).toArray();
//        Arrays.sort(priceArr);
//        int sum = 0;
//        // 比较值 不满条件输出结果
//        for (int anInt : priceArr) {
//            sum += anInt;
//            if (sum > maxParse) {
//                sum -= anInt;
//                break;
//            }
//        }
//        System.out.println(sum);
        exam(10, 2);
    }

    public static void exam(int m, int n) throws InterruptedException {
        Semaphore[] semaphores = new Semaphore[n];
        AtomicInteger result = new AtomicInteger(1);
        for (int i = 0; i < n; i++) {
            // 每个信号量初始计数都为1
            semaphores[i] = new Semaphore(1);
            if (i != n - 1) {
                //其他线程阻塞
                semaphores[i].acquire();
            }
        }
        for (int i = 0; i < n; i++) {
            // 初次执行，上一个信号量是 syncObjects[2]
            final Semaphore last = i == 0 ? semaphores[n - 1] : semaphores[i - 1];
            final Semaphore current = semaphores[i];
            new Thread(() -> {
                try {
                    while (true) {
                        last.acquire();
                        System.out.println(Thread.currentThread().getName() +": " + result.getAndIncrement());
                        if (result.get() > m) {
                            break;
                        }
                        current.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
