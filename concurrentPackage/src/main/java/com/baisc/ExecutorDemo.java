package com.baisc;

import java.util.concurrent.*;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 * 线程池的创建
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        //创建固定大小的线程池
        ExecutorService executorService1= Executors.newFixedThreadPool(5);
        //创建线程核心个数为1的线程池
        ExecutorService executorService2= Executors.newSingleThreadExecutor();
        //创建无限大小的线程池
        ExecutorService executorService3= Executors.newCachedThreadPool();

        /**
         * 创建核心线程数量为4 最大线程数量为10 线程池中线程存活时间为60s 线程缓存队列大小为5的 线程池
         */
        ExecutorService executorService4= new ThreadPoolExecutor(4,10,60L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
    }
}
