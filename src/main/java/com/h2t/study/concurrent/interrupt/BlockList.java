package com.h2t.study.concurrent.interrupt;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列响应中断测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/19 19:52
 */
public class BlockList {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
        thread.start();
        Thread.sleep(3 * 1000);  //睡眠3s
        thread.interrupt();
    }

    public static class Task implements Runnable {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

        /**
         * 自定义任务
         */
        @Override
        public void run() {
            try {
                //一直阻塞，因为阻塞队列中没有元素
                arrayBlockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End...");
        }
    }
}
