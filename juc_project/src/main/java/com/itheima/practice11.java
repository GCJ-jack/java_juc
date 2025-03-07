package com.itheima;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class practice11 {
    static int a = 0;

    static Object room = new Object();
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 5000; i++){
                synchronized (room){
                    a++;
                }

            }
        },"小明");

        Thread t2 = new Thread(()-> {
            for(int i = 0; i < 5000; i++){
                synchronized (room){
                    a--;
                }

            }
        },"小红");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug(String.valueOf(a));
    }
}
