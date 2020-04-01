package com.alice.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuchun
 * @date 2020/02/16  10:34
 */
public class ReentrantLockUseDemo {

    private Lock lock = new ReentrantLock();

    public void testLock() {
        lock.lock();
        try {
            // your code
        } finally {
            lock.unlock();
        }
    }


    public void testTryLock() {
        if (lock.tryLock()) {
            // your code
            lock.unlock();
        }

        try {
            if (lock.tryLock(1000L, TimeUnit.MILLISECONDS)) {
                // your code
                lock.unlock();
            }
        } catch (InterruptedException e) {

            // exception code 如果线程中断我们可以在这写一些东西，根据自己的业务需求
            e.printStackTrace();
        }
    }

    /**
     * 异常可以直接抛出，交由调用放处理，也可以自己处理掉
     *
     * @throws InterruptedException
     */
    public void testLockInterruptibly() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            //your code
        } finally {
            lock.unlock();
        }
    }
}
