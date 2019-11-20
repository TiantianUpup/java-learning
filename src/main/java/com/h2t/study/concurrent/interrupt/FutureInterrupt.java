package com.h2t.study.concurrent.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用future对象来取消任务
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/20 14:29
 */
public class FutureInterrupt {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<?> oneMinutefuture = es.submit(new OneMinuteTask(555));
        Future<?> ioFuture = es.submit(new IOTask(System.in));
        //System.out.println("任务是否已完成： " + future.isDone());
        oneMinutefuture.cancel(true);
        ioFuture.cancel(true);
        //System.out.println("任务是否被取消: " + future.isCancelled());
        //如果任务被cancel，该方法返回true
        //System.out.println("任务是否已完成： " + future.isDone());
    }

    public static class OneMinuteTask implements Runnable {
        int i;

        public OneMinuteTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("SleepTask执行到了///");
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

    public static class IOTask implements Runnable {
        private InputStream inputStream;

        public IOTask(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        /**
         * 自定义任务
         */
        @Override
        public void run() {
            try {
                System.out.println("OneMinuteTask执行到了///");
                inputStream.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("End...");
        }
    }
}
