package com.itheima;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.*;

@Slf4j
public class practice42 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
//        // 添加两个任务，希望它们都在 1s 后执行
//        executor.schedule(() -> {
//            System.out.println("任务1，执行时间：" + new Date());
//            try { Thread.sleep(2000); } catch (InterruptedException e) { }
//        }, 1000, TimeUnit.MILLISECONDS);
//
//        executor.schedule(() -> {
//            System.out.println("任务2，执行时间：" + new Date());
//        }, 1000, TimeUnit.MILLISECONDS);

//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
//        log.debug("start...");
//        pool.scheduleAtFixedRate(() -> {
//            log.debug("running...");
//        }, 1, 1, TimeUnit.SECONDS);

        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future<Boolean> f = pool.submit(() -> {
            log.debug("task1");
            int i = 1 / 0;
            return true;
        });
        log.debug("result:{}", f.get());
    }
}
