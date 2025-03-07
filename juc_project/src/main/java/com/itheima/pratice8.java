package com.itheima;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class pratice8 {

    public static void main(String[] args) throws InterruptedException {

        log.debug("开始运行...");
        Thread t1 = new Thread(() -> {
            log.debug("开始运行...");
            try {
                sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("运行结束...");
        }, "daemon");
        // 设置该线程为守护线程
        t1.setDaemon(true);
        t1.start();
        sleep(1);
        log.debug("运行结束...");
    }
}
