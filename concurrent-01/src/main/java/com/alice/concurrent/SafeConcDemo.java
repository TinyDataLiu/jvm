package com.alice.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 线程安全，
 * 这里我们 synchronized 关键字来给同步代码块加锁，将本来并发执行的
 * 线程来进行串行的方式来保证结果的正确性
 *
 * @author liuchun
 * @date 2020/02/12  13:11
 */
@Slf4j
public class SafeConcDemo {
    private static int count = 0;

    private static synchronized void inc() {
        count++;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5000; i++) {
            new Thread(() -> {
                inc();
            }, "inc-" + i).start();
        }
//用于等待合适的时长来保证线程的充分运行
        System.in.read();
        log.info("count={}", count);
    }
}
