package com.itheima;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class practice10 {

    static String kettle = "冷水";

    static String tea = null;

    static final Object lock = new Object();

    static boolean maked = false;

    public static void makeTea(){

        new Thread(() -> {
            log.debug("洗水壶");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("烧开水");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },"老王").start();
    }
}
