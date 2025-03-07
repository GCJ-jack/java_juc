package com.itheima;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class practice1 {

    public static void main(String[] args) {


        Thread t1 = new Thread("t1"){
            @Override
            //执行方法内
            public void run(){
                log.debug("Hello World");
            }
        };

        t1.start();


        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                log.debug("Hello World");
            }
        };

        Thread t2 = new Thread(r1);
        t2.start();
    }
}
