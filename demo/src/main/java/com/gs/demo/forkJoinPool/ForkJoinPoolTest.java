package com.gs.demo.forkJoinPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * @User远
 * @Date2022/3/23
 */
public class ForkJoinPoolTest {
    public static void main(String[] args) throws Exception {
        testHasResultTask();
    }
    public static void testHasResultTask() throws Exception {
        int result1 = 0;
        long time = System.currentTimeMillis();
        for (int i = 1; i <= 1000000; i++) {
            result1 += i;
        }
        long costTime = System.currentTimeMillis()-time;
        System.out.println("循环计算 1-1000000 累加值：" + result1 + "耗时：" + costTime);

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new CalculateTask(1, 1000000));
        int result2 = task.get();
        costTime = System.currentTimeMillis()-time;
        System.out.println("并行计算 1-1000000 累加值：" + result2 + "耗时：" + costTime);
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}


class CalculateTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 1L;
    private static final int THRESHOLD = 49;
    private int start;
    private int end;

    public CalculateTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int result = 0;
            for (int i = start; i <= end; i++) {
                result += i;
            }
            return result;
        } else {
            int middle = (start + end) / 2;
            CalculateTask firstTask = new CalculateTask(start, middle);
            CalculateTask secondTask = new CalculateTask(middle + 1, end);
            invokeAll(firstTask,secondTask);
            return firstTask.join() + secondTask.join();
        }
    }

}