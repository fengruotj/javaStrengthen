package com.basic.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * locate com.basic.thread.lock
 * Created by mastertj on 2018/5/16.
 *
 * 使用读写锁，可以实现读写分离锁定，读操作并发执行，写操作锁定单个线程
 *
 * 如果有一个线程已经占用了读锁，则其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁
 * 如果有一个线程已经占用了写锁，则其他线程如果要申请写锁或者读锁，则申请的线程会一直等待释放读锁
 */
public class MyReentrantReadWriteLock {
    private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public static void main(String[] args) {
        MyReentrantReadWriteLock myReentrantReadWriteLock=new MyReentrantReadWriteLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myReentrantReadWriteLock.read();
                myReentrantReadWriteLock.write();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myReentrantReadWriteLock.read();
                myReentrantReadWriteLock.write();
            }
        }).start();
    }

    public void read(){
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        readLock.lock();
        try {
            long startTimeMills=System.currentTimeMillis();
            while (System.currentTimeMillis()-startTimeMills<=1){
                System.out.println(Thread.currentThread().getName()+" 进行读操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write(){
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        try {
            long startTimeMills=System.currentTimeMillis();
            while (System.currentTimeMillis()-startTimeMills<=1){
                System.out.println(Thread.currentThread().getName()+" 进行写操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
