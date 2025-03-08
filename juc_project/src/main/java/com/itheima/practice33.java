package com.itheima;

import static java.lang.Thread.sleep;

public class practice33 {
    static int x;

    public static void main(String[] args) {
        Thread t2 = new Thread(()->{
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println(x);
                    break;
                }
            }
        },"t2");
        t2.start();
        new Thread(()->{
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x = 10;
            t2.interrupt();
        },"t1").start();
        while(!t2.isInterrupted()) {
            Thread.yield();
        }
        System.out.println(x);
    }

}
