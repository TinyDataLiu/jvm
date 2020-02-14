package com.alice.concurrent.sync;

/**
 * @author liuchun
 * @date 2020/02/12  14:12
 */
public class SyncDemo {

    private Object lock = new Object();

    /**
     * 修饰实例方法，进入同步代码块前需要获取实例
     */
    private synchronized void add(){}

    /**
     * 修饰静态方法，进入同步代码前需要获得类锁
     */
    private synchronized static void sub(){}

    /**
     * 修饰代码块，进入同步代码块前需要获取指定对象的锁。这里只lock
     */
    private void div(){
        synchronized (lock){

        }
    }
}
