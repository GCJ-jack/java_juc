package com.itheima;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

@Slf4j
public class practice7 {

    static int r1 = 0;
    static int r2 = 0;


    public static void test3() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            r1 = 10;
        });
        Long start = System.currentTimeMillis();
        t1.start();
        t1.join(1500);
        Long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);
    };


    public static void test4() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.debug("线程被打断，但我们手动清除了打断标记");
                boolean interruptedStatus = Thread.interrupted(); // 这里清除打断标记
                log.debug("打断标记是否被清除？{}", interruptedStatus);
            }

        },"t1");

        t1.start();
        sleep(500);
        t1.interrupt();
        log.debug(" 打断状态: {}", t1.isInterrupted());
    }


    public static void test5() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                Thread thread = Thread.currentThread();
                boolean interruptedStatus = thread.isInterrupted();
                log.debug("当前线程状态：{}", interruptedStatus);
                if (interruptedStatus) {
                    break;
                }
            }
        },"t1");

        t1.start();
        sleep(5000);
        t1.interrupt();
    }

    //使用park方法不会清空 打断的状态
    public static void test6() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("开始线程");
            LockSupport.park();
            log.debug("unpark...");
            log.debug("打断状态：{}", Thread.currentThread().isInterrupted());
        },"t1");
        t1.start();
        sleep(1000);
        t1.interrupt();
        log.debug("结束");
    }

    //如果打断线程已经是true那么park无法终止线程

    public static void test7() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for(int i  = 0; i < 5; i++) {
                log.debug("park....");
                LockSupport.park();
                log.debug("线程状态 {}" , Thread.currentThread().isInterrupted());
            }
        },"t1");

        t1.start();
        sleep(1000);
        t1.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
//        test3();
        test7();
    }
}
