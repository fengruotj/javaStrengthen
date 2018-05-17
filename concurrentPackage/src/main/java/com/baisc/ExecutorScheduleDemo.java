package com.baisc;

import java.util.concurrent.*;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 * 调度线程池的创建
 */
public class ExecutorScheduleDemo {
    public static void main(String[] args) {
        //创建线程核心个数为1的调度线程池
        ScheduledExecutorService executorService1= Executors.newSingleThreadScheduledExecutor();
        //创建线程核心个数为4的调度线程池
        ScheduledExecutorService executorService2= Executors.newScheduledThreadPool(4);
    }
}
