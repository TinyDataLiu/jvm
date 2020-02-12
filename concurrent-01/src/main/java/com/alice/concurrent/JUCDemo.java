package com.alice.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用JUC 包下的线程安全类
 *
 * @author liuchun
 * @date 2020/02/12  13:29
 */
@Slf4j
public class JUCDemo {

    private static AtomicInteger count = new AtomicInteger(0);

    private static Integer count1 = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5000; i++) {
            new Thread(() -> {
                count.incrementAndGet();
            }).start();
        }

        synchronized (JUCDemo.class) {

        }
        System.in.read();
        log.info("count={}", count.get());
    }
}
