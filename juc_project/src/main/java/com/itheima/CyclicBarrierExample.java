package com.itheima;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
//        int threadCount = 3;
//        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
//            System.out.println("所有线程都到达屏障点"); });
//        for (int i = 0; i < threadCount; i++) {
//            new Thread(() -> {
//                try { // 执行任务
//                    System.out.println(Thread.currentThread().getName() + " 到达屏障点");
//                    barrier.await(); // 继续执行后续任务
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            ).start();
//        }

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    System.out.println("执行栅栏任务 " + Thread.currentThread().getName());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("完成任务");
            }).start();
        }

        Thread.sleep(5000);
        cyclicBarrier.await();
    }
}