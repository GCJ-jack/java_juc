package com.itheima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

class Chopsticks extends ReentrantLock {
    String name;
    public Chopsticks(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "筷子{" + name + '}';
    }
}

@Slf4j
class Philosophers extends Thread    {
    Chopsticks left;
    Chopsticks right;
    public Philosophers(String name, Chopsticks left, Chopsticks right) {
        super(name);
        this.left = left;
        this.right = right;
    }
    @Override
    public void run() {
        while (true) {
// 尝试获得左手筷子
            if (left.tryLock()) {
                try {
// 尝试获得右手筷子
                    if (right.tryLock()) {
                        try {
                            try {
                                eat();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } finally {
                            right.unlock();
                        }
                    }
                } finally {
                    left.unlock();
                }
            }
        }
    }
    private void eat() throws InterruptedException {
        log.debug("eating...");
        sleep(1000);
    }
}


public class practice28 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(false);
        lock.lock();
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " running...");
                }
            }, "t" + i).start();
        }
        // 1s 之后去争抢锁
        Thread.sleep(1000);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start...");
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " running...");
            } finally {
                lock.unlock();
            }
        }, "强行插入").start();
        lock.unlock();
    }
}
