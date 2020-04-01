package com.alice.jvm;

public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock(true);
        DeadLock deadLock2 = new DeadLock(false);

        Thread t1 = new Thread(deadLock1);
        Thread t2 = new Thread(deadLock2);

        t1.start();
        t2.start();
    }
}

/**
 * 锁对象
 */
class MyLock {
    public static Object object1 = new Object();
    public static Object object2 = new Object();
}

class DeadLock implements Runnable {
    private boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (MyLock.object1) {
                    System.out.println(Thread.currentThread().getName() + "----if 获得obj1锁");
                    synchronized (MyLock.object2) {
                        System.out.println(Thread.currentThread().getName() + "----if 获得obj2锁");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (MyLock.object2) {
                    System.out.println(Thread.currentThread().getName() + "----if 获得obj2锁");
                    synchronized (MyLock.object1) {
                        System.out.println(Thread.currentThread().getName() + "----if 获得obj1锁");
                    }
                }
            }
        }
    }
}
