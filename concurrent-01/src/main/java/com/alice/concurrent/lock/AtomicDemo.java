package com.alice.concurrent.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuchun
 * @date 2020/02/16  11:09
 */
@Slf4j
public class AtomicDemo {

    private static int count = 0;
    private final static Lock lock = new ReentrantLock();

    public static void inc() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3000; i++) {
            new Thread(AtomicDemo::inc).start();
        }
        //等待线程充分运行
        TimeUnit.SECONDS.sleep(3);
        log.info("count={}", count);
    }
}
