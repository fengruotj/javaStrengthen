package com.basic.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * locate com.basic.thread.lock
 * Created by mastertj on 2018/5/16.
 * tryLock()方法是有返回值的，它表示用来尝试获取锁，如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），则返回false，
 * 也就是说这个方法无论如何都会立即返回，在拿不到锁时不会一直等待
 */
public class MyTryLockTest {
    private static Lock lock=new ReentrantLock();

    private static List<Integer> integers=new ArrayList<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean b = lock.tryLock();
                System.out.println(Thread.currentThread().getName()+" 获取锁:"+b);
                if(b) {
                    try {
                        for (int i = 0; i < 10; i++) {
                            integers.add(i);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(Thread.currentThread().getName() + " 释放锁");
                        lock.unlock();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean b = lock.tryLock();
                System.out.println(Thread.currentThread().getName()+" 获取锁:"+b);
                if(b) {
                    try {
                        for (int i = 0; i < 5; i++) {
                            integers.add(i);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(Thread.currentThread().getName() + " 释放锁");
                        lock.unlock();
                    }
                }
            }
        }).start();
    }
}
