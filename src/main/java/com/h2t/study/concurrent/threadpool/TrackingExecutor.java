package com.h2t.study.concurrent.threadpool;

import java.util.*;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * shutdownNow方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/18 9:54
 */
public class TrackingExecutor extends AbstractExecutorService {
    private static ExecutorService es;

    /**
     * 同步set,存放未完成的任务
     */
    private static Set<Runnable> tasksCancelledAtShutdown = Collections.synchronizedSet(new HashSet<>());

    public TrackingExecutor(ExecutorService es) {
        this.es = es;
    }

    public List<Runnable> getCancelledTasks() {
        if (!es.isTerminated()) {
            throw new IllegalStateException();
        }

        return new ArrayList<>(tasksCancelledAtShutdown);
    }

    @Override
    public void execute(Runnable command) {
        //封装提交的Runnable任务，执行完毕后判断后线程池是否关闭&当前线程是否被中断
        es.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    command.run();
                } finally {
                    //Thread.currentThread().isInterrupted() => 有些任务无法中断
                    if (isShutdown() && Thread.currentThread().isInterrupted()) {
                        tasksCancelledAtShutdown.add(command);
                    }
                }
            }
        });
    }


    @Override
    public void shutdown() {
        es.shutdownNow();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return es.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return es.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return es.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return es.awaitTermination(timeout, unit);
    }
}
