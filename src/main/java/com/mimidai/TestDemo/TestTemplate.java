package com.mimidai.TestDemo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhangyu on 2017/11/1.
 */
abstract class TestTemplate {
    private String id;
    protected int round;
    private int threadNum;
    protected long countValue;
    protected AtomicLong countValueAtomic = new AtomicLong(0);
    protected int[] preInit;
    protected int index;
    protected AtomicInteger indexAtomic = new AtomicInteger(0);
    Random r = new Random(47);
    private CyclicBarrier cb;

    public TestTemplate(String id, int round, int threadNum, CyclicBarrier cb) {
        this.id = id;
        this.round = round;
        this.threadNum = threadNum;
        this.cb = cb;
        preInit = new int[round];
        for (int i = 0; i < preInit.length; i++) {
            preInit[i] = r.nextInt(100);
        }
    }

    abstract void sumValue();

    /**
     * 对long的操作都是非原子，原子操作只针对32位
     * long是64位，底层操作的时候分2个32位读写，因此不是线程安全
     */
    abstract long getValue();

    public void testTime() {
        ExecutorService se = Executors.newCachedThreadPool();
        long start = System.nanoTime();
        //同时开启2*ThreadNum个数的读写线程
        for (int i = 0; i < threadNum; i++) {
            se.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < round; i++) {
                        sumValue();
                    }
                    //每个线程执行完同步
                    try {
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            se.execute(new Runnable() {
                public void run() {

                    getValue();
                    try {
                        //每个线程执行完同步方法后就等待
                        cb.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });
        }
        try {
            cb.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long duration = System.nanoTime() - start;
        System.out.println(id + " = " + duration);

    }
}
