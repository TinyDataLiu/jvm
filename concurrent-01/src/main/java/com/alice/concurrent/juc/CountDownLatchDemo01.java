package com.alice.concurrent.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * 使用案例
 * main 线程之外的线程我们均称之为子线程
 * 在所有子线程调用countDown 之前，主线程将一直阻塞在latch.await();
 *
 * @author liuchun
 * @date 2020/02/12  14:03
 */
@Slf4j
public class CountDownLatchDemo01 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                log.info("执行完毕");
                latch.countDown();
            }, "t" + i).start();
        }
        //上面的五个线程执行完毕之前，主线程将一直阻塞等待
        latch.await();
        log.info("执行完毕");
    }
}
