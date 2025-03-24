package com.itheima;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("获取许可");
                    //执行任务
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println("释放许可");
                }
            }).start();
        }
    }
}
