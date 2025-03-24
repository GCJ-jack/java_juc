package com.itheima;

public class SafeStopWithFlag implements Runnable{
    private volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                System.out.println("running");
                Thread.sleep(1000);
            } catch (Exception e) {
                flag = false;
                Thread.currentThread().interrupt();
            }
            System.out.println("terminate");
        }
    }

    public void stop(){
        flag = false;
    }

    public static void main(String[] args) throws InterruptedException {
        SafeStopWithFlag safeStopWithFlag = new SafeStopWithFlag();

        Thread thread = new Thread(safeStopWithFlag);
        thread.start();
        //以防立马停止
        thread.sleep(3000);
        safeStopWithFlag.stop();
    }
}
