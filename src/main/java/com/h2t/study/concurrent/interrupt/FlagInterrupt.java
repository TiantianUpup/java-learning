package com.h2t.study.concurrent.interrupt;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 使用flag标志判断任务是否停止
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/19 15:57
 */
public class FlagInterrupt {
    /**
     * 是否停止任务标志位
     */
    private volatile boolean flag = false;

    /**
     * 阻塞队列&队列中不添加任何值
     */
    private ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        FlagInterrupt flagInterrupt = new FlagInterrupt();
        flagInterrupt.start();  //启动任务
        Thread.sleep(10 * 1000);
        flagInterrupt.stop();  //执行10s停止执行的任务
    }

    public void stop() {
        flag = true;
    }

    public void start() {
        //new Thread(new Task()).start();
        new Thread(new MyTask()).start();
    }

    private class Task implements Runnable {
        @Override
        public void run() {
            int i = 0;
            //如果任务不停止一直累加打印结果
            while (!flag) {
                System.out.println(i++);
            }
        }
    }

    /**
     * 自定义任务，run方法中调用了阻塞方法
     */
    private class MyTask implements Runnable {
        @Override
        public void run() {
            while (!flag) {
                try {
                    //队列中无值，将被阻塞
                    arrayBlockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
