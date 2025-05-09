package com.itheima;


public class ThreadLocalExample {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

            String threadName = Thread.currentThread().getName();
            System.out.println("设置线程的名字"+threadName);
            threadLocal.set(threadName);
            try {
                Thread.sleep(2000); // 模拟延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("读取线程的名字"+threadLocal.get());
        });

        Thread thread1 = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            //设计线程的名字
            threadLocal.set(threadName);

            System.out.println("设置线程的名字"+threadName);

            System.out.println(threadName);
            System.out.println("读取线程的名字"+threadLocal.get());

        });

        thread.start();
        thread1.start();
    }
}
