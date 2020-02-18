package com.alice.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liuchun
 * @date 2020/02/18  10:25
 */
public class LockSupportDemo {


    public void packVia() {
        LockSupport.park(this);
        System.out.println("=====================");
    }

    public static void main(String[] args) {

        LockSupport.unpark(Thread.currentThread());
        LockSupportDemo demo = new LockSupportDemo();

        demo.packVia();


    }
}
