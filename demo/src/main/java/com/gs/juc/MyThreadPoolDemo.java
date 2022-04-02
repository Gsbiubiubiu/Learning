package com.gs.juc;

import java.util.concurrent.*;

/**
 * @User远
 * @Date2022/3/2
 */

/**
 *      线程池的优势：
 *          线程池做的工作主要是控制运行的线程数量，处理过程中将任务放入队列，然后在线程创建后启动任务
 *          如果线程数量超过了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行
 *      主要特点：
 *          线程复用，控制最大并发数，管理线程
 *      第一：降低资源消耗，通过重复利用已创建的线程降低线程创建和销毁造成的损耗
 *      第二：提高响应速度，当任务到达时，任务可以不需要等待线程创建就能立即执行
 *      第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性
 *          使用线程池可以进行统一的分配，调优，监控
 *
 */


/**
 *      底层调用的ThreadPoolExecutor
 *      一般会自定义线程池
 *      有七个参数
 *      public ThreadPoolExecutor(int corePoolSize,
 *                               int maximumPoolSize,
 *                               long keepAliveTime,
 *                               TimeUnit unit,
 *                               BlockingQueue<Runnable> workQueue,
 *                               ThreadFactory threadFactory,
 *                               RejectedExecutionHandler handler)
 *      corePoolSize：线程池中的常驻核心线程数
 *      maximumPoolSize：线程池中能够容纳同时执行的最大线程数，此值必须大于等于1
 *      keepAliveTime：多余的空闲线程的存活时间
 *          当前池中线程数量超过corePoolSize时，当空闲时间达到keepAliveTime时，多余线程会被销毁
 *          直到只剩下corePoolSize个线程为止
 *      unit: keepAliveTime的单位
 *      workQueue: 任务队列，被提交但尚未被执行的任务
 *      threadFactory: 表示生成线程池中工作线程的线程工厂，用于创建线程，一般默认即可
 *      handler: 拒绝策略， 表示当队列满了，并且工作线程大于等于线程池中的最大线程数时，
 *      如何来拒绝请求执行的runnable策略。
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //defaultPool();
        //customization();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    /**
     *     线程池的拒绝策略：
     *          等待队列已经满了，无法塞下新任务，同时线程池中max线程也达到，这个时候我们就需要拒绝策略。
     *
     *   四大拒绝策略：
     *      AbortPolicy(默认): 直接抛出java.util.concurrent.RejectedExecutionException异常，阻止系统正常运行
     *      CallerRunsPolicy: "调用者运行"一种调节机制，该策略即不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量
     *      (main线程执行)
     *      DiscardOldestPolicy: 抛弃队列中等待最久的任务，然后把当前任务加入队列中，尝试再次提交当前任务
     *      DiscardPolicy: 该策略默默丢弃无法处理的任务，不予任何处理也不抛异常。如果允许任务丢失，这是最好的一种策略
     */
    private static void customization() {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try{
            for (int i = 0; i < 9; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+ "\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }

    private static void defaultPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 1池 5线程
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor(); // 1池 1线程
        ExecutorService threadPool2 = Executors.newCachedThreadPool(); // 1池 N线程 (视并发情况而定)
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch(Exception ignored){

        }finally {
            threadPool.shutdown();
        }
    }
}
