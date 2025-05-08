package com.itheima;


public class WaitNotifyExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread producer = new Thread(()-> {
            synchronized (lock) {
                try {
                    System.out.println("producer producing");
                    Thread.sleep(1000);
                    System.out.println("producer done");
                    //唤醒等待的线程
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()-> {
            synchronized (lock) {
                try{
                    System.out.println("consumer waiting");
                    lock.wait();
                    Thread.sleep(2000);
                    System.out.println("consumer finish waiting, start consuming");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        consumer.start();
        producer.start();

    }
}
