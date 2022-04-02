package com.gs.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @User远
 * @Date2022/2/10
 */
@Slf4j
public class ThreadCreateDemo_1 {
    public static void main(String[] args) {
        SomeRunnable someRunnable = new SomeRunnable();
        Thread thread1 = new Thread(someRunnable);
        thread1.start();
        Thread thread2 = new Thread(() -> {
            log.info("使用lamda表达式, {}", Thread.currentThread().getName());
        });
        thread2.start();
    }

}

@Slf4j
class SomeRunnable implements Runnable{
    @Override
    public void run() {
      log.info("通过实现Runnable接口创建线程, {}", Thread.currentThread().getName());
    }
}
