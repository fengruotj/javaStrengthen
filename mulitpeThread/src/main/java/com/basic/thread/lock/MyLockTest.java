package com.basic.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * locate com.basic.thread.lock
 * Created by mastertj on 2018/5/16.
 * lock方法是平常使用得最多得方法，就是用来获取锁的。如果锁已被其他线程获取，则进行等待。
 */
public class MyLockTest {
    private static Lock lock=new ReentrantLock();

    private static List<Integer> integers=new ArrayList<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 获取锁");
                lock.lock();
                try {
                    for(int i=0;i<5;i++){
                        integers.add(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName()+" 释放锁");
                    lock.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 获取锁");
                lock.lock();
                try {
                    for(int i=0;i<5;i++){
                        integers.add(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName()+" 释放锁");
                    lock.unlock();
                }

            }
        }).start();
    }
}
