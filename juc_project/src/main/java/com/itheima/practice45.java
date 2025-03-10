package com.itheima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

@Slf4j
class DataContainer {
    private Object data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public Object read() throws InterruptedException {
        log.debug("获取读锁...");
        r.lock();
        try {
            log.debug("读取");
            sleep(1000);
            return data;
        } finally {
            log.debug("释放读锁...");
            r.unlock();
        }
    }
    public void write() {
        log.debug("获取写锁...");
        w.lock();
        try {
            log.debug("写入");
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            log.debug("释放写锁...");
            w.unlock();
        }
    }
}
public class practice45 {
    public static void main(String[] args) throws InterruptedException {
//        DataContainer dataContainer = new DataContainer();
//
//        new Thread(() -> {
//            try {
//                dataContainer.read();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, "t1").start();
//
//        new Thread(() -> {
//            try {
//                dataContainer.read();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, "t2").start();

        DataContainer dataContainer = new DataContainer();
        new Thread(() -> {
            try {
                dataContainer.read();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();

        Thread.sleep(100);
        new Thread(() -> {
            dataContainer.write();
        }, "t2").start();

    }
}
