package com.baisc;

import java.util.concurrent.BlockingQueue;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 * 阻塞队列生产者
 */
public class Producer implements Runnable{
    private BlockingQueue<String> blockingDeque;

    public Producer(BlockingQueue<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        try {
            String temp="生产者线程："+Thread.currentThread().getName();
            Thread.sleep(2000);
            blockingDeque.put(Thread.currentThread().getName()+" : "+temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
