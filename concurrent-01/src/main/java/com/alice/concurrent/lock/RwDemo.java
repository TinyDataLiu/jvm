package com.alice.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liuchun
 * @date 2020/02/16  11:24
 */
public class RwDemo {

    static Map<String, Object> cache = new HashMap<>();
    final static ReentrantReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
    final static Lock R = RW_LOCK.readLock();
    final static Lock W = RW_LOCK.writeLock();

    public static final Object get(String key) {
        R.lock();
        try {
            return cache.get(key);
        } finally {
            R.unlock();
        }
    }


    public static final Object put(String key, Object v) {
        W.lock();
        try {
            return cache.put(key, v);
        } finally {
            W.unlock();
        }
    }
}
