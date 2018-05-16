package com.basic.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * locate com.basic.thread.lock
 * Created by mastertj on 2018/5/16.
 * 当通过这个方法获取锁时，如果线程正在等待获取锁，则这个线程能够响应中断，即中断线程的等待状态。
 * 比如就是说当两个线程同时调用Lockinterruptibly获取锁时，假使线程A获取到了锁，那么线程B只能等待。此时我们可以通过threadB.interrupt()方法能够中断线程B的等待过程。
 */
public class MyInterupptibly implements Runnable{
    private Lock lock=new ReentrantLock();

    public static void main(String[] args) {
        MyInterupptibly interupptibly=new MyInterupptibly();
        Thread threadA=new Thread(interupptibly);
        Thread threadB=new Thread(interupptibly);
        threadA.start();
        threadB.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.interrupt();
        threadB.interrupt();
        System.out.println("======================");
    }

    public void insert() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(Thread.currentThread().getName()+" 获取锁");

            //执行逻辑
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
             lock.unlock();
            System.out.println(Thread.currentThread().getName()+" 释放锁");
        }
    }
    @Override
    public void run() {
        try {
            insert();
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName()+" 线程被中断");
            e.printStackTrace();
        } finally {
        }
    }
}
