package com.csy.discuss.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService scheduledThread = Executors.newScheduledThreadPool(2);
        ExecutorService cachedThread = Executors.newCachedThreadPool();
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        fixedThreadPool.execute(new Run());
    }

    static class Run implements Runnable {

        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
