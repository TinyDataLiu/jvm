package com.alice.concurrent.fj;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuchun
 * @date 2020/02/23  9:40
 */
@Slf4j
public class ArrayTransform extends RecursiveTask<Integer> {

    AtomicInteger integer = new AtomicInteger(0);

    int[] array;
    int num;
    int start;
    int end;
    int threshold = 2;


    public ArrayTransform(int[] array, int num, int start, int end) {
        this.array = array;
        this.num = num;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) < threshold) {
            computeDirectly();
        } else {
            int mid = (start + end) / 2;
            ArrayTransform subTask1 = new ArrayTransform(array, num, start, mid);
            ArrayTransform subTask2 = new ArrayTransform(array, num, mid, end);
            invokeAll(subTask1, subTask2);
        }
        return null;
    }


    protected void computeDirectly() {
        for (int i = start; i < end; i++) {
            array[i] = array[i] * num;
        }
        log.info("computeDirectly");
    }

}
