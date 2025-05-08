package com.itheima;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionExample {

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        //生产者线程
        Thread producer = new Thread(() -> {
            lock.lock();
            try{
                System.out.println("生产者生产中");
                Thread.sleep(2000);
                System.out.println("生产者完成生产");
                //试图唤醒其他的线程
                condition.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        //消费者线程
        Thread consumer = new Thread(() -> {
            lock.lock();
            try{
                System.out.println("消费者开始等待获得产品");
                condition.await();
                System.out.println("商品生产完成，消费者开始消费");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        consumer.start();
        Thread.sleep(2000);
        producer.start();
    }
}
