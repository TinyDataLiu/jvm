package com.alice.concurrent.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            executorService.execute(new SingleThreadExecutorDemo(i));
        }
    }
}
