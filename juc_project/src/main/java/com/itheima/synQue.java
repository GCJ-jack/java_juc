package com.itheima;



import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.SynchronousQueue;

@Slf4j
public class synQue {

    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        Thread thread = new Thread(() -> {
            try {
                log.debug(Thread.currentThread().getThreadGroup() + "放入元素 1");
                queue.put(1);
                log.debug(Thread.currentThread().getThreadGroup() + "放入元素 2");
                queue.put(2);
                log.debug(Thread.currentThread().getThreadGroup() + "放入元素 2");
                queue.put(3);
            }catch (Exception e){
                e.printStackTrace();
            }
        });


        Thread thread1 = new Thread(() -> {
            try {
                log.debug(Thread.currentThread().getThreadGroup() + "取出元素 1");
                queue.take();
                log.debug(Thread.currentThread().getThreadGroup() + "取出元素 2");
                queue.take();
                log.debug(Thread.currentThread().getThreadGroup() + "取出元素 2");
                queue.take();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        thread.start();
        thread1.start();

        System.out.println("完成");
    }
}
