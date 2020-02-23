package com.alice.concurrent.fj;

import java.util.concurrent.RecursiveTask;

/**
 * @author liuchun
 * @date 2020/02/23  10:13
 */
public class Query extends RecursiveTask<Integer> {

    int total = 10000;

    int current = 0;

    public Query(int total, int current) {
        this.total = total;
        this.current = current;
    }

    @Override
    protected Integer compute() {
        if (current > total) {

        }
        return null;
    }
}
