package com.baisc.thread.testThread;

/**
 * locate com.baisc.thread.testThread
 * Created by mastertj on 2018/5/16.
 * 比较Synchronized同步锁关键字的用法
 */
public class MySynchronized {
    public static void main(String[] args) {
        MySynchronized mySynchronized1=new MySynchronized();
        MySynchronized mySynchronized2=new MySynchronized();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mySynchronized1){
                    try {
                        System.out.println(Thread.currentThread().getName()+" start");
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName()+" 过了5s钟,醒了");
                        System.out.println(Thread.currentThread().getName()+" end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //启动第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mySynchronized1){
                    try {
                        System.out.println(Thread.currentThread().getName()+" start");
                        System.out.println(Thread.currentThread().getName()+" end");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
