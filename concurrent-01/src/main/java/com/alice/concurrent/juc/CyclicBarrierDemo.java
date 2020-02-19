package com.alice.concurrent.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author liuchun
 * @date 2020/02/19  15:34
 */
@Slf4j
public class CyclicBarrierDemo {

    /**
     * 复习下 volatile 关键字， 建议使用 Atomic
     */
    static volatile int integer = 0;


    public static void main(String[] args) {
        AtomicBoolean notFinished = new AtomicBoolean(true);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            // 这里什么也没做，只是将标记下子任务已经全部完成，通知主任务可以不用等待了，继续运行即可
            notFinished.set(Boolean.FALSE);
            log.info("子任务已经全部完成");
        });
        long l = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new SubThread(i, cyclicBarrier).start();
        }
        log.info("------------------------------------");
        while (notFinished.get()) {
        }
        log.info("开始主任务{}", integer);
    }


    static class SubThread extends Thread {
        private int part;
        private CyclicBarrier cyclicBarrier;

        public SubThread(int i, CyclicBarrier cyclicBarrier) {
            this.part = i;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(part);
                log.info("子任务{}，已完成", part);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
