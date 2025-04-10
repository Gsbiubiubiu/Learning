package com.gs.juc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author: Gaos
 * @Date: 2024-06-17 11:41
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<CompletableFuture<Integer>> futures = nums.stream()
                .map(value -> CompletableFuture.supplyAsync(() -> {
                    System.out.println(value+"------");
                    return value;
                })).collect(Collectors.toList());
        CompletableFuture<Integer> sumFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApplyAsync(v -> {
                    // 所有的异步任务计算完成后，将他们结果合并
                    int sum = futures.stream()
                            .mapToInt(CompletableFuture::join)
                            .sum();
                    return sum;
                });
        Integer sum = sumFuture.join();
        System.out.println(sum);
    }
}