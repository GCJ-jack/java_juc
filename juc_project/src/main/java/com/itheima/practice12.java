package com.itheima;

import lombok.extern.slf4j.Slf4j;

class Room{
    int value = 0;

    public void increase(){
        synchronized (this){
            value++;
        }

    }

    public void decrease(){
        synchronized (this){
            value--;
        }

    }

    public int getValue(){
        synchronized (this) {
            return value;
        }
    }
}

@Slf4j
public class practice12 {

    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                room.increase();
            }

        },"小明");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                room.decrease();
            }
        },"小红");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        log.debug(String.valueOf(room.getValue()));
    }
}
