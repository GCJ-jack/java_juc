package com.itheima;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 3;

        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i=0;i<threadCount;i++){
            new Thread(()->{

                try {
                    //执行任务
                    System.out.println(Thread.currentThread().getName() + "完成任务");
                }finally {
                    countDownLatch.countDown();
                }

            }).start();
        }

        countDownLatch.await();
        System.out.println("完成所有任务");
    }
}
