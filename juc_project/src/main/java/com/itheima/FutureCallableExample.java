package com.itheima;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors. newSingleThreadExecutor();

        Callable<Integer> callable = () -> {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10000);
            return 42;
        };

        Future<Integer> future = executorService.submit(callable);

        System.out.println("主线执行其他的任务");

        System.out.println("主线程继续执行其他的任务");

        try{
            Integer result = future.get();
            System.out.println("得到结果" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
