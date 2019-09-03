package com.csy.discuss.core.asq;

public class InterruptionInJava implements Runnable {

    private volatile static boolean on = false;

    public static void main(String[] args) throws InterruptedException {

        Thread testThread = new Thread(new InterruptionInJava(),"InterruptionInJava");
        //start thread
        testThread.start();
        //interrupt thread
        testThread.interrupt();
        InterruptionInJava.on = true;

//        testThread.sleep(10000);
//
//        testThread.interrupted();
//        InterruptionInJava.on = false;

        System.out.println("main end");

    }

    @Override
    public void run() {
        System.out.println(1);
        while(!on){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Yes,I am interruted,but I am still running");

            }else{
                System.out.println("not yet interrupted");
            }
        }
    }

}
