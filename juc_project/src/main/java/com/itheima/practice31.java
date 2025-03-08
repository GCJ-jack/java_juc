package com.itheima;

import static java.lang.Thread.sleep;

public class practice31 {

//    static int x;
//    static Object m = new Object();

//    volatile static int x;

    static int x;

    public static void main(String[] args) throws InterruptedException {

//        new Thread(()->{
//            synchronized(m) {
//                x = 10;
//            }
//        },"t1").start();
//
//        new Thread(()->{
//            synchronized(m) {
//                System.out.println(x);
//            }
//        },"t2").start();

//        new Thread(()->{
//            x = 10;
//        },"t1").start();
//        new Thread(()->{
//            System.out.println(x);
//        },"t2").start();


        new Thread(()->{
            System.out.println(x);
        },"t2").start();
        sleep(1000);
        x = 10;
    }
}
