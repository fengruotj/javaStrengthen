package com.baisc.thread.testThread;

/**
 * locate com.baisc.thread.testThread
 * Created by mastertj on 2018/5/16.
 * 使用Runable实现的方法启动线程
 */
public class MyThreadWithImplement implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" 运行线程......");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       Thread thread=new Thread(new MyThreadWithImplement());
       thread.start();
    }
}
