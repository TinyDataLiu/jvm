package com.alice.concurrent.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liuchun
 * @date 2020/02/22  10:28
 */
@Slf4j
public class SingleThreadExecutorDemo implements Runnable {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    private int i;

    public SingleThreadExecutorDemo(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        log.info("i={}", i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadPoolExecutor executor = (ThreadPoolExecutor) executorService;
            executor.allowCoreThreadTimeOut(Boolean.TRUE);
            executorService.execute(new SingleThreadExecutorDemo(i));
        }
    }
}
