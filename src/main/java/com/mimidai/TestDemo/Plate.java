package com.mimidai.TestDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 类文件注释(Class file)
 *
 * @author focus
 * @classDescription 多线程测试
 * @create 2017-11-17 16:11
 **/
public class Plate {

    List<Object> eggs = new ArrayList<Object>();

    public  Object getEgg() {
        while (eggs.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        Object egg = eggs.get(0);
        eggs.clear();// 清空盘子
        notify();// 唤醒阻塞队列的某线程到就绪队列
        System.out.println("拿到鸡蛋");
        return egg;
    }

    public  void putEgg(Object egg) {
        while (eggs.size() > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        eggs.add(egg);// 往盘子里放鸡蛋
        notify();// 唤醒阻塞队列的某线程到就绪队列
        System.out.println("放入鸡蛋");
    }

    static class AddThread extends Thread {
        private Plate plate;
        private Object egg = new Object();

        public AddThread(Plate plate) {
            this.plate = plate;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                plate.putEgg(egg);
            }
        }
    }

    static class GetThread extends Thread {
        private Plate plate;

        public GetThread(Plate plate) {
            this.plate = plate;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                plate.getEgg();
            }
        }
    }

    public static void main(String args[]) {
        try {
            Plate plate = new Plate();
            Thread add = new Thread(new AddThread(plate));
            Thread get = new Thread(new GetThread(plate));
            add.start();
            get.start();
            add.join();
            get.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("测试结束");
    }
}
