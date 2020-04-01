package com.alice.concurrent.bq;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liuchun
 * @date 2020/02/21  14:06
 */
@Slf4j
public class MessageService {

    protected ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(10);


    {
        init();
    }


    private final void init() {
        new Thread(() -> {
            while (true) {
                try {
                    String take = messageQueue.take();
                    log.info("信息发送：{}", take);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.info("发送信息异常", e);
                }
            }
        }).start();
    }
}
