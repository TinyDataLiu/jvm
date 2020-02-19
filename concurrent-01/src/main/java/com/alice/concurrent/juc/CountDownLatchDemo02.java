package com.alice.concurrent.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 这个案例是模拟并发场景， 注意与之前的案例对比，这里是把countDown 放在主线程之中
 * 也就是在countDown 调用之前所有的子线程，都需要阻塞
 * 我们可以模拟某些子任务，等待主任务执行到某一步才能继续执行的场景。
 *
 * @author liuchun
 * @date 2020/02/12  14:03
 */
@Slf4j
public class CountDownLatchDemo02 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                    log.info("并发执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "t" + i).start();
        }

        //在主线程调用，countDown 之前，所有的子线程一直阻塞，在latch.await();
        TimeUnit.SECONDS.sleep(3);
        log.info("执行完毕---->"); // 这句话一定会在所有子任务执行之前执行。
        latch.countDown(); //调用countDown 通知所有子线程的程序可以运行了。
    }
}
