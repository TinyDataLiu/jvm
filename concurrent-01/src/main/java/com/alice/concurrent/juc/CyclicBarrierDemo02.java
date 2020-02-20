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
public class CyclicBarrierDemo02 {

    /**
     * 复习下 volatile 关键字， 建议使用 Atomic
     */
    static volatile int integer = 0;


    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean notFinished = new AtomicBoolean(true);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        log.info("getNumberWaiting={},getParties={}", cyclicBarrier.getNumberWaiting(), cyclicBarrier.getParties());
        long l = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new SubThread(i, cyclicBarrier).start();
        }

//        TimeUnit.SECONDS.sleep(6);

        log.info("getNumberWaiting={},getParties={}", cyclicBarrier.getNumberWaiting(), cyclicBarrier.getParties());
        log.info("------------------------------------");
//        while (cyclicBarrier.getParties() > 0) {
//
//        }
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
                //所有任务会阻塞在这里 ，等到所有的线程运行到这个节点的时候，才会后续的操作。
                cyclicBarrier.await();
                log.info("子任务{}，已完成", part);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
