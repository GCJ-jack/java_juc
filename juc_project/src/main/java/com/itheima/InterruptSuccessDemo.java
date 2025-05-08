package com.itheima;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

@Slf4j
public class InterruptSuccessDemo {
    public static void main(String[] args) throws InterruptedException {

//        Thread thread = new Thread(()-> {
//            while (!Thread.currentThread().isInterrupted()){
//                try{
//                    log.debug("线程运行中");
//                } catch (Exception e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//            System.out.println("线程优雅停止。");
//        });
//
//
//        thread.start();
//        Thread.sleep(3000);
//        thread.interrupt();
//
//        log.debug("打断完成");

//        FutureTask<Integer> task3 = new FutureTask<>(() -> {
//            log.debug("hello");
//            return 100;
//        });

//        int numberThreads = 3;
//
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberThreads, () -> {
//            log.debug("所有人到齐，一起出发");
//        });
//
//
//        for (int i = 1; i <= numberThreads; i++) {
//            int workId = i;
//            new Thread(() -> {
//                try {
//                    System.out.println("线程 " + workId  + " 正在准备...");
//                    Thread.sleep((long) (Math.random() * 2000)); // 模拟准备时间
//                    System.out.println("线程 " + workId + " 到达屏障点，等待其他人...");
//                    cyclicBarrier.await();
//                    log.debug("线程 " + workId + "继续执行任务...");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }


//        CountDownLatch countDownLatch = new CountDownLatch(5);
//
//
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName()+"==>start");
//                countDownLatch.countDown();
//            }).start();
//        }
//        countDownLatch.await();
//        System.out.println("main线程继续向下执行");


        Semaphore semaphore = new Semaphore(5);


        for (int i = 1; i <= 6; i++) {
            int temp = i;

            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(temp + "号车抢到车位");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
