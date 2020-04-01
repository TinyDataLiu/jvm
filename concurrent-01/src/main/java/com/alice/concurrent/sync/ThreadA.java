package com.alice.concurrent.sync;

/**
 * @author liuchun
 * @date 2020/02/14  13:11
 */
public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("ThreadA start");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadA end");
        }
    }
}
