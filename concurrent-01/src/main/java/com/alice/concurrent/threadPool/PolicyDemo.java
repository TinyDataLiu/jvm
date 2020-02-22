package com.alice.concurrent.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author liuchun
 * @date 2020/02/22  19:12
 */
@Slf4j
public class PolicyDemo implements RejectedExecutionHandler {


    static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new MyThreadFactory(), new PolicyDemo());


    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "my-thread");
        }
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.info("my");
    }


    public static void main(String[] args) {
        executor.allowCoreThreadTimeOut(Boolean.TRUE);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                log.info("");
            });
        }
    }
}
