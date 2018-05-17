package com.baisc;

import java.util.concurrent.BlockingQueue;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 * 阻塞队列消费者
 */
public class Consumer implements Runnable{
    private BlockingQueue<String> blockingDeque;

    public Consumer(BlockingQueue<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        try {
            String temp="消费者线程："+Thread.currentThread().getName();
            String take = blockingDeque.take();
            System.out.println(temp+"---------"+take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
