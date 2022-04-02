package com.gs.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @User远
 * @Date2022/3/1
 */

/**
 * 三个车位 六个人来抢
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        successfulTest();
    }

    /**
     * 在信号量上我们定义两种操作：
     *      acquire(获取) 当一个线程调用acquire操作时, 他要么通过成功获得信号量。(此时信号量-1)
     *          要么一直等下去，直到有线程释放信号量，或超时.
     *      release(释放) 实际上会将信号量的值+1， 然后唤醒等待的线程
     *      信号量主要用于两个目的， 一个是用于多个共享资源的互斥使用， 另一个用于并发线程数的控制。
     */
    private static void successfulTest() {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+ "\t 抢占到了车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
