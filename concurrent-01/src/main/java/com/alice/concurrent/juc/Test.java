package com.alice.concurrent.juc;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuchun
 * @date 2020/02/20  14:38
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
//        int i = Integer.numberOfLeadingZeros(16) | (1 << (16 - 1));
//        System.out.println((i << 16) + 2);
        int c = 16;
        String[] str = new String[c << 1];
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 20000; i++) {
            String s = RandomStringUtils.random(8, false, true);

            int run = Integer.valueOf(s) & 16;

            if (run == 16 || run == 0) {
                atomicInteger.incrementAndGet();
            }


        }
        log.info("{}", atomicInteger.get());

    }
}
