package com.itheima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

@Slf4j
public class practice26 {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            log.debug("启动...");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("等锁的过程中被打断");
                return;
            }
            try {
                log.debug("获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        log.debug("获得了锁");
        t1.start();
        try {
            sleep(1);
            t1.interrupt();
            log.debug("执行打断");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
