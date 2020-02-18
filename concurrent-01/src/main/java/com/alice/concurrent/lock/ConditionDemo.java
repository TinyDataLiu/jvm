package com.alice.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuchun
 * @date 2020/02/18  16:12
 */
public class ConditionDemo {


    private final Lock lock = new ReentrantLock();

    private final Condition condition_1 = lock.newCondition();
    private final Condition condition_2 = lock.newCondition();







}
