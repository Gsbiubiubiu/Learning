package com.gs.juc;

/**
 * @User远
 * @Date2022/3/2
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 *      阻塞：必须要阻塞/不得不阻塞
 *      阻塞队列也是一种队列，在数据接口中
 *      线程1往阻塞队列中添加元素，线程2从阻塞队列中移除元素
 *          当队列为空时，从队列中获取元素的操作将被阻塞
 *          当队列是满的时，从队列中添加元素的操作将被阻塞
 *      试图从空的队列中获取元素的线程将会被阻塞，直到其他线程往空的队列插入新的元素
 *      试图从已满的队列中添加新元素的线程将会被阻塞，直到其他线程从队列中移除一个或多个元素或者完全清空
 *      使队列变得空闲起来并后续新增
 */

/**
 *      在多线程领域：所谓阻塞，再某些情况下会挂起线程（即阻塞），一旦条件满足，被挂起的线程又会自动被唤醒
 *      为什么需要BlockingQueue？！
 *      好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程，这一切由BlockingQueue进行操作
 *
 *      在concurrent包发布之前，在多线程环境下，我们需要自己去控制这些细节，兼顾效率和安全，这会给程序带来十分高的复杂度
 */

/**
 * BlockQueue为一个接口 下有一些实现类
 *      ArrayBlockingQueue: 由数组结构组成的有界阻塞队列
 *      LinkedBlockingQueue: 由链表结构组成的有界（但大小默认值为integer.MAX_VALUE）阻塞队列
 *      PriorityBlockingQueue: 支持优先级排序的无界阻塞队列
 *      DelayQueue：使用优先级队列实现的延迟无界阻塞队列
 *      SynchronousQueue：不存储元素的阻塞队列，也即单个元素的队列
 *      LinkedTransferQueue：由链表组成的无界阻塞队列
 *      LinkedBlockingDeque：由链表组成的双向阻塞队列
 */
public class BlockQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());
    }
}
