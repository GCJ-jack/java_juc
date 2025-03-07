package com.itheima;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class practice6 {


    static Integer r1 = 0;

    static Integer r2 = 0;

    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() ->{
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            r1  = 10;
        });

        Thread t2 = new Thread(() ->{
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            r1  = 20;
        });

        Long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);
    }

    public static void main(String[] args) throws InterruptedException {
        test2();
    }
}
