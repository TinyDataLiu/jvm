package com.alice.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 多线程情况下，不安全的
 *
 * @author liuchun
 * @date 2020/02/12  13:11
 */
@Slf4j
public class UnsafeConcDemo {


    private static int count = 0;


    private static void inc() {
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
