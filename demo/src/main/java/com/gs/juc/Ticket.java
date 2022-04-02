package com.gs.juc;

import java.util.HashMap;
import java.util.Map;

/**
 * @User远
 * @Date2022/2/10
 */
public class Ticket extends Thread{
    private static int ticketNums = 100;
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Ticket ticket3 = new Ticket();

        ticket1.start();
        ticket2.start();
        ticket3.start();
    }

    @Override
    public void run() {
        while (true) {
            if (ticketNums <=0) {
                System.out.println("票已经售罄！");
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("售票窗口：" + Thread.currentThread().getName() + " 售出一张票," + "剩余票数为：" + (--ticketNums));
            Map map = new HashMap();
        }
    }
}
