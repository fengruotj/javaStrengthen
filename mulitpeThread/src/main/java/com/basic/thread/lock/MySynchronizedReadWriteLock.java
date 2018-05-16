package com.basic.thread.lock;

/**
 * locate com.basic.thread.lock
 * Created by mastertj on 2018/5/16.
 * 一个线程又要读又要写，用synchronized来实现的话，读写操作都只能锁住后一个线程一个线程的执行
 */
public class MySynchronizedReadWriteLock {
    /**
     * 读写操作
     * @param threadName
     */
    public synchronized void get(String threadName){
        long startTimeMills=System.currentTimeMillis();
        int i=0;
        while (System.currentTimeMillis()-startTimeMills<=1){
            i++;
            if(i%4==0){
                System.out.println(Thread.currentThread().getName()+" 进行读操作");
            }else {
                System.out.println(Thread.currentThread().getName()+" 进行写操作");
            }
        }
        System.out.println(Thread.currentThread().getName()+" 读写操作完毕");
    }

    public static void main(String[] args) {
        MySynchronizedReadWriteLock writeLock=new MySynchronizedReadWriteLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                writeLock.get(Thread.currentThread().getName());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                writeLock.get(Thread.currentThread().getName());
            }
        }).start();
    }
}
