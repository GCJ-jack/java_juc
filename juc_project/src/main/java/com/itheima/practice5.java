package com.itheima;


import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class practice5 {

    static int r = 0;

    private static void test1() throws InterruptedException {
        log.debug("方法一开始 创立新的线程");

        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("结束");
            r = 10;

        });
        t1.start();
        t1.join();
        log.debug("结果为 {}",r);
        log.debug("结束");
    }


    public static void main(String[] args) throws InterruptedException {

        test1();

    }
}

