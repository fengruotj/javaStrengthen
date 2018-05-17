package com.baisc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 */
public class ThreadPoolWithRunable {
    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        for(int i=0;i<20;i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "当前线程执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }
}
