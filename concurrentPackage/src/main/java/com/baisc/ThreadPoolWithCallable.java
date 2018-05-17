package com.baisc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 * Callable 和 Runnable的区别：
 * runnable的run方法不会有任何返回的结果，所以主线程无法获得任务线程的返回值
 *
 * Callable的Call方法可用返回结果，但是主线程在获取时是被阻塞，需要等待任务线程返回才能拿到结果
 */
public class ThreadPoolWithCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        List<Future> futureList=new ArrayList<>();
        for(int i=0;i<20;i++){
            System.out.println(i);
            Future<String> submit = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "b--" + Thread.currentThread().getName();
                }
            });
            futureList.add(submit);
        }

        //从Future中get结果时一个阻塞方法 一直等到线程任务返回结果
        for(Future future:futureList){
            System.out.println("执行结果："+future.get());
        }
        executorService.shutdown();
    }
}
