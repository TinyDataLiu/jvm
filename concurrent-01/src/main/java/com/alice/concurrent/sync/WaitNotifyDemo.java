package com.alice.concurrent.sync;

/**
 * @author liuchun
 * @date 2020/02/14  13:05
 */
public class WaitNotifyDemo {


    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.start();
        ThreadB threadB = new ThreadB(lock);
        threadB.start();
    }

}
