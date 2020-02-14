package com.alice.concurrent.sync;

/**
 * @author liuchun
 * @date 2020/02/14  13:11
 */
public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("ThreadB start");
            lock.notify();
            System.out.println("ThreadB end");
        }
    }
}
