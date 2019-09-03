package com.csy.discuss.core.asq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndCustomer {

    private int count = 0;
    public final int MAX_COUNT = 10;
    private static AtomicBoolean flag = new AtomicBoolean(true);
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition push = reentrantLock.newCondition();
    Condition take = reentrantLock.newCondition();

    public void push() throws InterruptedException {
        reentrantLock.lock();
        while (count >= 1) {
            System.out.println("库存大于等于1个，阻塞停止生产！");
            push.await();
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "生产者生产，库存：" + count);
        take.signal();
        reentrantLock.unlock();
    }

    public void take() throws InterruptedException {

        reentrantLock.lock();
        while (count <= 0) {
            System.out.println("拿的太快啦，收手停止一下啦！");
            take.await();
        }

        count--;
        System.out.println("有人偷偷拿走一个商品，还剩:" + count);
        push.signal();
        reentrantLock.unlock();

    }

    static class Customer implements Runnable {
        private ProducerAndCustomer producerAndCustomer;

        public Customer(ProducerAndCustomer producerAndCustomer) {
            this.producerAndCustomer = producerAndCustomer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    producerAndCustomer.take();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Producer implements Runnable {
        private ProducerAndCustomer producerAndCustomer;

        public Producer(ProducerAndCustomer producerAndCustomer) {
            this.producerAndCustomer = producerAndCustomer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    producerAndCustomer.push();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void main(String[] args) {

        ProducerAndCustomer producerAndCustomer = new ProducerAndCustomer();

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        executorService.execute(new Producer(producerAndCustomer));

        executorService.execute(new Customer(producerAndCustomer));


    }

}




