package com.itheima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


@Slf4j
public class practice2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建任务对象
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {

           log.debug("future task");

            return 100;
        });

        //参数 1 是任务对象 参数2是线程名称 推荐

        Thread thread = new Thread(futureTask,"t1");
        thread.start();
        //主线程阻塞 等待得到结果
        Integer number = futureTask.get();

        log.debug("future task end {}", number);

    }
}
