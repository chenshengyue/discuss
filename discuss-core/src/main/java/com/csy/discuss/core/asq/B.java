package com.csy.discuss.core.asq;

import lombok.Getter;
import lombok.Setter;

public class B {

    public static Integer max = 10;

    public static Lock lock = new Lock();

    @Getter
    @Setter
    public static class Lock {

        private Integer count = 0;

        private boolean flag;

        public void incr() {
            count ++;
        }

    }

    static class ProductRun implements Runnable {

        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    if (lock.count >= max) {
                        break;
                    }
                    if (!lock.flag && lock.count < max) {
                        lock.incr();
                        System.out.println(Thread.currentThread().getName() + "_" + lock.count);
                        sleep();
                        lock.flag = true;
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class ConsumerRun implements Runnable {

        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    if (lock.count >= max) {
                        break;
                    }
                    if (lock.flag && lock.count < max) {
                        lock.incr();
                        System.out.println(Thread.currentThread().getName() + "_" + lock.count);
                        sleep();
                        lock.flag = false;
                        lock.notifyAll();
                    }
                }
            }
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new ProductRun()).start();
        new Thread(new ProductRun()).start();
        new Thread(new ConsumerRun()).start();
        new Thread(new ConsumerRun()).start();
    }
}
