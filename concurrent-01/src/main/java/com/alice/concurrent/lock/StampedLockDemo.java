package com.alice.concurrent.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author liuchun
 * @date 2020/02/16  11:32
 */
public class StampedLockDemo {

    StampedLock stampedLock = new StampedLock();

    public void setStampedLock(StampedLock stampedLock) {
        this.stampedLock = stampedLock;

    
    }


}
