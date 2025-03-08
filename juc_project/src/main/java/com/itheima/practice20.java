package com.itheima;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

@Slf4j
public class practice20 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("park...");
            LockSupport.park();
            log.debug("resume...");
        },"t1");
        t1.start();
        sleep(2);
        log.debug("unpark...");
        LockSupport.unpark(t1);
    }
}
