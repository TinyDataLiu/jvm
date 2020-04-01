package com.alice.concurrent.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuchun
 * @date 2020/02/22  19:12
 */
@Slf4j
public class PolicyDemo implements RejectedExecutionHandler {


    static ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 1, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new PolicyDemo());


    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "my-thread");
        }
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        AtomicInteger integer = new AtomicInteger(executor.getMaximumPoolSize());
        // 动态修改后从新执行
        executor.setMaximumPoolSize(integer.incrementAndGet());
        executor.execute(r);
        log.info("{}", integer.get());
    }


    public static void main(String[] args) {
        executor.allowCoreThreadTimeOut(Boolean.TRUE);
        // 由调用者线程来处理
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        直接抛出异常
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//        抛弃最早的，并执行当前任务，淘汰最先提交的
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
//        什么也不做直接丢弃该任务 与DiscardOldestPolicy 相反，淘汰最后提交的任务
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
//      自定义的，可以根据自己的需求自定义,比如我们实现了，允许线程池动态扩容的机制，虽然有点扯。
        executor.setRejectedExecutionHandler(new PolicyDemo());
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                log.info("task");
            });
        }
    }
}
