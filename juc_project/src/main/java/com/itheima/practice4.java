package com.itheima;

public class practice4 {

    public static void main(String[] args) {

        Thread t1 = new Thread("t1"){
            int count  = 0;
            public void run(){

                for(;;){
                    System.out.println("---->1 " + count++);
                }
            }
        };


        Thread t2 = new Thread("t2"){
            int count  = 0;
            public void run(){

                for(;;){
                    System.out.println("---->2 " + count++);
                }
            }
        };

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
