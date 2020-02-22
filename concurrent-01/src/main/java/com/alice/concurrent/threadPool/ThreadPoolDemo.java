package com.alice.concurrent.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuchun
 * @date 2020/02/22  9:32
 */
@Slf4j
public class ThreadPoolDemo implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("{}", Thread.currentThread().getName());
    }


    static ExecutorService executorService = Executors.newFixedThreadPool(3);


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ThreadPoolDemo());
        }
        executorService.shutdown();
    }
}
