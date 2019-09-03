package com.csy.discuss.core.asq;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ArrayBlockingQueueDemo {

    public static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(8);

    public static LinkedBlockingQueue<Integer> queue1 = new LinkedBlockingQueue(8);

    public static void main(String[] args) {

        queue.add(0);
        new Thread(new Run(false)).start();
        new Thread(new Run(false)).start();


    }

    static class Run implements Runnable {

        private boolean sleep;

        public Run(boolean sleep) {
            this.sleep = sleep;
        }

        @Override
        public void run() {
            try {
                queue.add(1);
                System.out.println(Thread.currentThread().getName() + "1");
                if (sleep) {
                    Thread.sleep(1000);
                }
                queue.put(2);
                System.out.println(Thread.currentThread().getName() + "2");
                queue.put(3);
                System.out.println(Thread.currentThread().getName() + "3");
                queue.put(4);
                System.out.println(Thread.currentThread().getName() + "4");

                System.out.println(JSON.toJSONString(queue));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
