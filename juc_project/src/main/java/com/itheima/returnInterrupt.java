package com.itheima;

public class returnInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("检测到中断，return 退出线程");
                    return;
                }

                System.out.println("线程正在执行任务...");
                try {
                    Thread.sleep(500); // 模拟阻塞，响应中断
                }catch (InterruptedException e) {
                    // sleep 被中断时，会清除中断标志，必须手动重新设置
                    System.out.println("sleep 被中断，重新设置中断标志");
                    Thread.currentThread().interrupt(); // 恢复中断状态
                }
            }
        });

        Thread.sleep(3000);
        thread.start();
        System.out.println("线程被打断");
        thread.interrupt();
    }
}
