package com.itheima;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockexample {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {

            lock.lock();
            try {
                System.out.println("producer producing products....");
                Thread.sleep(2000);
                System.out.println("finish producing waking up the consumer...");
                condition.await();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        Thread consumer = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("consumer consuming products....");
                Thread.sleep(2000);
                System.out.println("consumer finish consuming waking up the producer...");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        producer.start();
        consumer.start();
    }
}
