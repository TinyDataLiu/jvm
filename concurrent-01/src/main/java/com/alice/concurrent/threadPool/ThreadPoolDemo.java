package com.alice.concurrent.threadPool;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.*;

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


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ThreadPoolDemo());
            Future<String> submit = executorService.submit((Callable<String>) () -> RandomStringUtils.random(10));
             
        }
        executorService.shutdown();
    }
}
