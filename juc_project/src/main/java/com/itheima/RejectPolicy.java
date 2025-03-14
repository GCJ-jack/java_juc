package com.itheima;

import java.util.concurrent.BlockingQueue;

@FunctionalInterface // 拒绝策略
interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}