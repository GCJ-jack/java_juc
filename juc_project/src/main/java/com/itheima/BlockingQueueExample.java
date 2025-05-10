package com.itheima;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);

    public static void main(String[] args) throws InterruptedException {
//        //生产者线程
//        Thread producer = new Thread(() -> {
//            try{
//                System.out.println("producer producing...");
//                queue.put(1);
//                System.out.println("producer finished");
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        });
//
//        //消费者线程
//        Thread consumer = new Thread(() -> {
//            try{
//                System.out.println("consumer waiting...");
//                int value = queue.take();
//                System.out.println("consumer finished");
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        });
//
//        consumer.start();
//        producer.start();

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);

//        System.out.println(queue.offer("a"));
//        System.out.println(queue.offer("b"));
//        System.out.println(queue.offer("c"));
//        System.out.println(queue.offer("d"));
//        System.out.println("----------------------");
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        //java.util.NoSuchElementException
//        System.out.println(queue.poll());

        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("c");
//        队列没有位置就会阻塞
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());

        System.out.println(Math.max(1,2));

    }
}
