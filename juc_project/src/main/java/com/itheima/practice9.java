package com.itheima;


import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class practice9 {

    public static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("洗水壶");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.debug("烧开水");
            try {
                sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.debug("完成洗水壶, 烧开水");
        },"洗水壶, 烧开水");

        Thread t2 = new Thread(() -> {
            log.debug("洗茶壶");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("洗茶叶");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("拿茶叶");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.debug("泡茶");

        },"洗茶壶,洗茶叶,拿茶叶");

        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }
}
