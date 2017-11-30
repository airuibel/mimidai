package com.mimidai.TestDemo;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 类文件注释(Class file)
 *
 * @author focus
 * @classDescription 测试线程池的构建
 * @create 2017-11-17 16:32
 **/
public class TestThreadPool {
    int count;

    public TestThreadPool(int count) {
        this.count = count;
    }

    public synchronized void add(int num) {
        count = count + num;
    }

    public synchronized void minus(int num) {
        count = count - num;
    }

    public static void main(String[] args) throws InterruptedException {
        TestThreadPool testThreadPool = new TestThreadPool(1000000);
        Thread a = new Thread(new AThread(testThreadPool,100), "a");
        Thread b = new Thread(new BThread(testThreadPool, 30), "b");
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(testThreadPool.count);
    }

    private static class AThread implements Runnable {
        int count;
        TestThreadPool i;

        public AThread(TestThreadPool i, int count) {
            this.count = count;
            this.i = i;
        }

        @Override
        public void run() {
            for (int j = 0; j < 5; j++) {
                i.minus(count);
                System.out.println("线程:"+Thread.currentThread().getName()+",count=:" + i.count);
            }
        }
    }

    private static class BThread implements Runnable {

        int count;
        TestThreadPool i;

        public BThread(TestThreadPool i, int count) {
            this.count = count;
            this.i = i;
        }

        @Override
        public void run() {
            for (int j = 0; j < 5; j++) {
                i.minus(count);
                System.out.println("线程:"+Thread.currentThread().getName()+",count==:" + i.count);
            }
        }
    }
}
