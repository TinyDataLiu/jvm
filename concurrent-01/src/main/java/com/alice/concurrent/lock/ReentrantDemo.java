package com.alice.concurrent.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * 演示重入锁的设计目的。
 * 本例中如果 synchronized 不是可从入，那么调用 demo.m1方法获取对象锁
 * 而m2 中获取了相同的锁。在不可以从入的前提下，会造成线程的死锁。
 *
 * @author liuchun
 * @date 2020/02/16  10:34
 */
@Slf4j
public class ReentrantDemo {
    public synchronized void m1() {
        log.info("begin");
        m2();
    }

    public void m2() {
        synchronized (this) {
            log.info("begin");

        }
    }

    public static void main(String[] args) {
        ReentrantDemo demo = new ReentrantDemo();
        new Thread(demo::m1).start();
    }
}
