package com.alice.concurrent.vola;

import lombok.extern.slf4j.Slf4j;

/**
 * 这个demo 演示了通过volatile 来终止线程的过程，
 * 当我们注释掉volatile 关键字的时候，线程不会按照我们预期的情况停止
 * 而打开注释的时候当运行到 stop = true 的时候线程会立即停止。
 *
 * @author liuchun
 * @date 2020/02/14  13:36
 */
@Slf4j
public class VolatileDemo {

    public volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        });


        thread.start();
        System.out.println("thread start");
        Thread.sleep(1000);
        stop = true;
        System.out.println("notify end");
    }
}
