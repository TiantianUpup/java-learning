package com.h2t.study.concurrent.threadpool;

import com.h2t.study.concurrent.threadpool.TrackingExecutor;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TrackingExecutor服务类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/18 11:19
 */
public class TrackingExecutorService {
    private TrackingExecutor trackingExecutor = new TrackingExecutor(Executors.newFixedThreadPool(3));

    private List<Runnable> runnableList;

    public void start() {
        //添加10个任务
        for (int i = 0; i < 5; i++) {
            trackingExecutor.execute(new Task(i));
        }
    }

    public void stop() {
        //立刻关闭线程池
        runnableList = trackingExecutor.shutdownNow();
        try {
            if (trackingExecutor.awaitTermination(30, TimeUnit.SECONDS)) {
                for (Runnable runnable : trackingExecutor.getCancelledTasks()) {
                    runnableList.add(runnable);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Runnable> getRunnableList() {
        return runnableList;
    }

    /**
     * 自定义任务
     * */
    private class Task implements Runnable {
        int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (true) {
                //执行一分钟
                if (System.currentTimeMillis() - start > 1000 * 60 * 2) {
                    break;
                }
            }

            System.out.println("i: " + i);
        }
    }
}
