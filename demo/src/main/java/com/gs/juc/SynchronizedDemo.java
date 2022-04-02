package com.gs.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @User远
 * @Date2022/2/10
 */
@Slf4j
public class SynchronizedDemo {
    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "C").start();
    }
}

@Slf4j
class Ticket1 {
    private int number = 100;
    public void sale() {
        if(number > 0){
            number--;
            log.info("name : {} number: {}", Thread.currentThread().getName(), number);

        }
//        System.out.println(Thread.currentThread().getName() + " : " + (number--) + " " + number);

    }
}