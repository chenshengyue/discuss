package com.csy.discuss.core.asq;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException {

//        Object lock = new Object();
//
//        LockSupport.park(lock);
//        System.out.println(Thread.interrupted());

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.tryLock();
        lock.unlock();
        lock.lockInterruptibly();
        lock.newCondition().await();
        lock.newCondition().signal();

        CountDownLatch startSignal = new CountDownLatch(1);
        startSignal.await();
        startSignal.countDown();
    }
}
