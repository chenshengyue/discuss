package com.csy.discuss.core.asq;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class A {

    //模拟数据库数据 Thread.currentThread().getName()
    private static List<Integer> DATA_BASE = Arrays.asList(new Integer[]{10, 10, 10, 9});

    public static void main(String[] args) {
        new Thread(new QueryRun(new Page())).start();
        System.out.println("正在处理数据，请耐心等待");
    }

    static class QueryRun implements Runnable {

        private Page page;

        public QueryRun(Page page) {
            this.page = page;
        }

        @Override
        public void run() {

            while (! page.isLastPage()) {
                Integer concurrentPage = page.getPageNo();
                System.out.println("query--->开始查询第" + concurrentPage + "页数据");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer data = DATA_BASE.get(concurrentPage);
                System.out.println("query--->结束查询第" + concurrentPage + "页数据");
                if (data < 10) {
                    page.setLastPage(true);
                    System.out.println("query--->查询结束,最后一页是第" + concurrentPage + "页");
                } else {
                    page.incrPageNo();
                }

                new Thread(new InsertRun(page)).start();
            }

        }
    }

    static class InsertRun implements Runnable {

        private Page page;

        public InsertRun(Page page) {
            this.page = page;
        }

        @Override
        public void run() {
            System.out.println("insert---> " + Thread.currentThread().getName() + "开始插入第" + page.getPageNo() + "页数据");
        }

    }

    @Getter
    @Setter
    static class Page {

        private Integer pageNo = 0;

        private Integer pageSize = 10;

        private boolean lastPage = false;

        private Date lastUpdateTime;

        public void incrPageNo() {
            pageNo++;
        }
    }
}
