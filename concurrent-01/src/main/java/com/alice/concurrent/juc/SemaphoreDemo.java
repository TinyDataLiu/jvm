package com.alice.concurrent.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 的使用案例
 * <p>
 * <p>
 * Semaphore 可以控制同时访问的线程数量。通过acquire获取一个许可。
 * 如果没有则等待，通过release 释放一个许可。可以多指导线程限流的功能。
 * 比如我们知允许一个资源同一时间点只允许五个线程访问。
 * <p>
 * <p>
 * 下面模拟一个停车位的场景，假设只有五个车位。也就是说`车位` 这个资源，只允许五个线程并行使用
 *
 * @author liuchun
 * @date 2020/02/19  15:34
 */
@Slf4j
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 代表有五个车位，就是五个线程可以并行访问资源。
        Semaphore semaphore = new Semaphore(5);
        // 模拟并发
        for (int i = 0; i < 10; i++) {
            new Car(i, semaphore).start();
        }
    }


    static class Car extends Thread {


        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }


        @Override
        public void run() {
            try {
                //占用资源，这里就是停车位，相当于车停进了车位
                semaphore.acquire();
                //逻辑处理开始
                log.info("第{}占用了一个停车位{}", num, semaphore.availablePermits());
                TimeUnit.SECONDS.sleep(2);
                //释放资源，相当于车开走了
                semaphore.release();
                log.info("第{}车开走了,剩余车位{}", num, semaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
