package com.h2t.study.concurrent.interrupt;

/**
 * wait阻塞响应中断
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/19 19:21
 */
public class WaitBlock {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
        thread.start();
        Thread.sleep(3 * 1000);
        thread.interrupt();
    }

    public static class Task implements Runnable {
        @Override
        public void run() {

            //睡眠足够长的时间，在测试时间内不会醒过来
            Test test = new Test();
            test.waitMethod();
            System.out.println("End...");
        }
    }

    private static class Test {
        public synchronized void waitMethod() {
            try {
                wait(1000 * 60 * 60 * 24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
