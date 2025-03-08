package com.itheima;


import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class practice22 {

    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                log.debug("lock A");
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (B) {
                    log.debug("lock B");
                    log.debug("操作...");
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                log.debug("lock B");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (A) {
                    log.debug("lock A");
                    log.debug("操作...");
                }
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
