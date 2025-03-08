package com.itheima;

public class MonitorService {
    // 标记是否已经启动（volatile 保证可见性）
    private volatile boolean starting;

    public void start() {
        System.out.println("尝试启动监控线程...");
        synchronized (this) {
            if (starting) {
                return;  // 如果已经启动，直接返回，不执行重复操作
            }
            starting = true;
        }
        // 真正启动监控线程...
        System.out.println("监控线程已启动...");
    }


    public static void main(String[] args) {
        MonitorService monitorService = new MonitorService();

        for(int i = 0; i < 5; i++){
            new Thread(()->{
                monitorService.start();
            },"t"+i).start();
        }
    }
}
