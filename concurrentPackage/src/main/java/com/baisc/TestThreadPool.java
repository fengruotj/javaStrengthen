package com.baisc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 */
public class TestThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        List<Future> futureList=new ArrayList<>();
        for(int i=0;i<20;i++){
            Future<Integer> submit = executorService.submit(new TaskCallable(i));
            futureList.add(submit);
        }

        for(Future future:futureList){
            System.out.println(future.isDone()?"已经完成":"没有完成");
            System.out.println("线程返回future结果"+future.get());
        }
        executorService.shutdown();
    }
}
