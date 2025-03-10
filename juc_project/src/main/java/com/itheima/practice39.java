package com.itheima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.SynchronousQueue;

import static java.lang.Thread.sleep;

@Slf4j
public class practice39 {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(() -> {
            log.debug("放入任务"+1);
            try {
                queue.put(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("放入任务"+2);
            try {
                queue.put(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t1").start();


        new Thread(() -> {
            log.debug("执行任务",+2);
            try {
                queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"t2").start();


        sleep(1000);
        new Thread(() -> {
            try {
                log.debug("taking {}", 2);
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();

    }
}
