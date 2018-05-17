package com.baisc;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 */
public class TaskCallable implements Callable<Integer>{
    private int i;

    private Random random=new Random();

    public TaskCallable(int i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"当前线程运行时间："+System.currentTimeMillis());
        int i = random.nextInt(3);
        System.out.println(Thread.currentThread().getName()+" is working......");
        Thread.sleep(i*1000);
        return this.i;
    }
}
