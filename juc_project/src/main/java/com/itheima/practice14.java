package com.itheima;


import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class practice14 {

    final static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {


        new Thread(() -> {
            synchronized (obj) {
                log.debug("执行。。。");
                try{
                    obj.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                log.debug("其他代码。。。。");
            }
        }).start();


        new Thread(() -> {
            synchronized (obj) {
                log.debug("执行....");
                try {
                    obj.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其它代码....");
            }
        }).start();

        // 主线程两秒后执行
        sleep(2);
        log.debug("唤醒 obj 上其它线程");
        synchronized (obj) {
//            obj.notify(); // 唤醒obj上一个线程
        obj.notifyAll(); // 唤醒obj上所有等待线程
        }
    }
}
