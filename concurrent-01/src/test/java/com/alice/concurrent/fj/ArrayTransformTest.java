package com.alice.concurrent.fj;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.*;

/**
 * @author liuchun
 * @date 2020/02/23  9:54
 */
@Slf4j
public class ArrayTransformTest {

    static final int SIZE = 10;

    static int[] arr = randomArr();

    private static int[] randomArr() {
        int[] arr = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    @Test
    public void test() {
        int num = 9;
        log.info("{}", arr);
        ArrayTransform mainTask = new ArrayTransform(arr, num, 0, SIZE);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
        log.info("{}", arr);
    }


}