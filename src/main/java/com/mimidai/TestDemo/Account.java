package com.mimidai.TestDemo;

/**
 * 类文件注释(Class file)
 *
 * @author focus
 * @classDescription 测试 多线程
 * @create 2017-11-17 15:14
 **/
public class Account {

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }


    public synchronized void add(int num) {
        balance = balance + num;
    }

    public synchronized void withdraw(int num) {
        balance = balance - num;
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000);
        Thread a = new Thread(new AddTread(account, 20), "add");
        Thread b = new Thread(new WithdrawThread(account, 20), "withdraw");
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(account.getBalance());


    }

    private static class AddTread implements Runnable {

        Account account;
        int amount;


        public AddTread(Account account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 200000; i++) {
                account.add(amount);
            }
        }
    }

    private static class WithdrawThread implements Runnable {

        Account account;

        int amount;

        public WithdrawThread(Account account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                account.withdraw(amount);
            }
        }
    }
}
