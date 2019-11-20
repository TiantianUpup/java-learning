package com.h2t.study.concurrent.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池使用shutdownNow关闭执行的任务
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/20 15:51
 */
public class ShutdownNowInterrupt {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new SleepTask());
        es.submit(new OneMinuteTask(555));
        Thread.sleep(3 * 1000);
        es.shutdownNow();  //3s后关闭线程
    }

    private static class SleepTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000 * 60 * 60 * 24);  //睡眠一天
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("SleepTask End");
        }
    }

    private static class OneMinuteTask implements Runnable {
        int i;

        public OneMinuteTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (true) {
                //执行一分钟
                if (System.currentTimeMillis() - start > 1000 * 60 * 1) {
                    break;
                }
            }

            System.out.println("OneMinuteTask End i= " + i);
        }
    }
}
