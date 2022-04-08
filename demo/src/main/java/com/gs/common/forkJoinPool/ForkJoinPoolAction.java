package com.gs.common.forkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ForkJoinPool.defaultForkJoinWorkerThreadFactory;

/**
 * @User远
 * @Date2022/3/23
 */
public class ForkJoinPoolAction {
    public static void main(String[] args) throws InterruptedException {
        PrintTask task = new PrintTask(0, 50);
        ForkJoinPool forkJoinPool = new ForkJoinPool(8,defaultForkJoinWorkerThreadFactory, null, false);
        forkJoinPool.submit(task);

        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }

}

class PrintTask extends RecursiveAction{
    private static final int THRESHOLD = 10;
    private int start;
    private int end;

    public PrintTask(int start, int end){
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end - start < THRESHOLD){
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName()+" 的i值" + i);
            }
        }else {
            int middle = (start+end)/2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            // 并行执行两个“小任务”
            left.fork();
            right.fork();
        }
    }
}
