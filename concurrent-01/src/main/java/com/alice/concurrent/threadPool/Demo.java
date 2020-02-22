package com.alice.concurrent.threadPool;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuchun
 * @date 2020/02/22  12:00
 */
@Slf4j
public class Demo {

    public static void main(String[] args) {


        cc:
        for (; ; ) {
            log.info("------------------");
            for (int i = 0; i < 10; i++) {
                if (i == 2) {
                    continue cc;
                } else {
                    log.info("i={}", i);
                }
            }
        }


//        log.info("end");
    }
}
