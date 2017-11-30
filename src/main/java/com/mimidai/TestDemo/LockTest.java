package com.mimidai.TestDemo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangyu on 2017/11/1.
 */
public class LockTest extends TestTemplate {
    ReentrantLock lock = new ReentrantLock();

    public LockTest(String id, int round, int threadNum, CyclicBarrier cb) {
        super(id, round, threadNum, cb);
    }

    @Override
    void sumValue() {
        try {
            lock.lock();
            super.countValue += preInit[index++ % round];
        }finally {
            lock.unlock();
        }
    }

    @Override
    long getValue() {
        try {
            lock.lock();
            return super.countValue;
        } finally {
            lock.unlock();
        }
    }

}
