package com.itheima;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestVolatile {

    volatile boolean initialized = false;
    synchronized void init() {
        if (initialized) {
            return;
        }
        doInit();
        initialized = true;
    }
    private void doInit() {

        log.debug("doInit");
    }

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                testVolatile.init();
            },"t" + i).start();
        }
    }
}
