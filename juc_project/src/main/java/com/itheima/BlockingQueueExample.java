package com.itheima;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);

    public static void main(String[] args) {
        //生产者线程
        Thread producer = new Thread(() -> {
            try{
                System.out.println("producer producing...");
                queue.put(1);
                System.out.println("producer finished");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        //消费者线程
        Thread consumer = new Thread(() -> {
            try{
                System.out.println("consumer waiting...");
                int value = queue.take();
                System.out.println("consumer finished");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        consumer.start();
        producer.start();
    }
}
