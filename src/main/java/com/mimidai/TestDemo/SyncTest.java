package com.mimidai.TestDemo;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by zhangyu on 2017/11/1.
 */
class SyncTest extends TestTemplate {
    public SyncTest(String id, int round, int threadNum, CyclicBarrier cb) {
        super(id, round, threadNum, cb);
    }

    @Override
    synchronized void sumValue() {
        super.countValue += preInit[index++ % round];
    }

    @Override
    synchronized long getValue() {
        return super.countValue;
    }
}
