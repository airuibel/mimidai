package com.mimidai.TestDemo;

/**
 * 类文件注释(Class file)
 *
 * @author focus
 * @classDescription 手动创建线程
 * @create 2017-11-17 11:58
 **/
public class TimerTaskTread extends Thread{
    private static  int x = 10;
    public TimerTaskTread(){
        super.setName("TimerTaskThread");

    }

    @Override
    public void run(){
        while(x>0){
            System.out.println("TimerTaskTread"+currentThread().getName()+"hello"+x++);
        }



    }
}
