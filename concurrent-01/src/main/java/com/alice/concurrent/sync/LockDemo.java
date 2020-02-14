package com.alice.concurrent.sync;

/**
 * @author liuchun
 * @date 2020/02/14  10:45
 */
public class LockDemo {


    public synchronized static void test() {
    }

    public static void main(String[] args) {
        synchronized (LockDemo.class) {

        }
        test();
    }
}
