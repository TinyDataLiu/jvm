package com.alice.concurrent.threadlocal;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuchun
 * @date 2020/02/22  19:50
 */
@Slf4j
public class ThreadLocalDemo {

    /**
     * 提供线程级别的隔离。线程范围的副本值
     * 线程级别隔离的。
     *
     * 1. 每个线程变量的副本是如何存储。
     * 2. 变量的副本是什么时候赋值的。
     */
    static ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 0);


    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                Integer integer = local.get();
                integer += 5;
                local.set(integer);
                log.info("integer={}", local.get());
            }, "thread-" + i);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
