package com.baisc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 * 线程池
 */
public class TestScheduleThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(4);
        List<Future> futureList=new ArrayList<>();
        for(int i=0;i<20;i++){
            Future<Integer> submit = executorService.schedule(new TaskCallable(i),2,TimeUnit.SECONDS);
            futureList.add(submit);
        }

        for(Future future:futureList){
            System.out.println(future.isDone()?"已经完成":"没有完成");
            System.out.println("线程返回future结果"+future.get());
        }
        executorService.shutdown();
    }
}
