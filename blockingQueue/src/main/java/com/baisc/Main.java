package com.baisc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * locate com.baisc
 * Created by mastertj on 2018/5/17.
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue blockingQueue=new ArrayBlockingQueue(5);
        for(int i=0;i<8;i++){
            new Thread(new Producer(blockingQueue)).start();
        }

        for(int i=0;i<8;i++){
            new Thread(new Consumer(blockingQueue)).start();
        }
    }
}
