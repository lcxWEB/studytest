package com.star.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: lcx
 * @Date: 2019/3/14 16:58
 * @Description:
 */

public class ConPrint {

    private final ExecutorService executorService;

    public ConPrint(ExecutorService executorService) {
        this.executorService = executorService;
    }

    void printNum(int[] nums) throws InterruptedException {
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
        for (final int num : nums) {
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    for (int i = 0; i < 1000000; i++) {
                        //耗时任务
                    }
                    // System.out.println(num + "--" + Thread.currentThread().getName());
                    // System.out.println(Thread.currentThread().getName());
                    return num;
                }
            });
            TimeUnit.MICROSECONDS.sleep(100);
        }
        try {
            int[] ret = new int[100];
            for (int i = 0, n = nums.length; i < n; i++) {
                Future<Integer> f = completionService.take();
                ret[i] = (f.get());
            }
            // Arrays.sort(ret);
            for (int i = 0; i < ret.length; i++) {
                System.out.println(ret[i]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) {
            nums[i] = i + 1;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        long start = System.nanoTime();
        new ConPrint(executorService).printNum(nums);
        System.out.println((System.nanoTime() - start) / 1000000000.0);
        executorService.shutdown();
    }

}
