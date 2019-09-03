package com.csy.discuss.core.asq;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        synchronized (o) {
            o.notifyAll();
        }

//        List<Integer> list = new ArrayList<>();
//        Producer producer = new Producer(list, o);
//        Consumer consumer = new Consumer(list, o);
//        ConsumerThread c = new ConsumerThread(consumer);
//        Thread.sleep(1000);
//        ProduceThread p = new ProduceThread(producer);
//        p.start();
//        c.start();
    }

    static class Producer {
        //共享数据
        private List<Integer> list;

        //    对象锁
        private Object object;

        public Producer(List list, Object object) {
            this.list = list;
            this.object = object;
        }

        public void produce() {
            //如果仓库不为空 我就等待
            synchronized (object) {
                while (list.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + "生产线程即将等待");
                    try {
                        super.wait();
                    } catch (InterruptedException e) {
                    }
                }
                //为空 生产数据
                System.out.println("即将生产");
                list.add(333);
                super.notifyAll();
            }
    }
    }

    static class Consumer {

        //共享数据
        private List<Integer> list;
        //    对象锁

        private Object object;
        public Consumer(List list, Object object) {
            this.list = list;
            this.object = object;
        }

        public void consume() {
            //如果仓库为空 我就等待
            synchronized (object) {
                while (!list.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + "消费者线程即将等待");
                    try {
                        super.wait();
                    } catch (InterruptedException e) {
                    }
                }
                //不为空 消费、
                System.out.println("即将消费");
                list.clear();
                super.notifyAll();
            }
        }
    }
    static class ConsumerThread extends Thread {
        private Consumer consumer;

        public ConsumerThread(Consumer consumer) {
            this.consumer = consumer;
        }

        @Override
        public void run() {
            while (true) {
                consumer.consume();
            }
        }
    }
    static class ProduceThread extends Thread {
        private Producer producer;

        public ProduceThread(Producer producer) {
            this.producer = producer;
        }

        @Override
        public void run() {
            while (true) {
                producer.produce();
            }
        }
    }
}






