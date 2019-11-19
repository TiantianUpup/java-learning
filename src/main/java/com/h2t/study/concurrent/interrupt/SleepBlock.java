package com.h2t.study.concurrent.interrupt;

/**
 * sleep阻塞响应中断
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/19 18:45
 */
public class SleepBlock {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
        thread.start();
        Thread.sleep(3 * 1000);  //睡眠3s
        thread.interrupt();
    }

    public static class Task implements Runnable {
        /**
         * 自定义任务
         */
        @Override
        public void run() {
            try {
                //睡眠足够长的时间，在测试时间内不会醒过来
                Thread.sleep(1000 * 60 * 60 * 24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End...");
        }
    }
}
