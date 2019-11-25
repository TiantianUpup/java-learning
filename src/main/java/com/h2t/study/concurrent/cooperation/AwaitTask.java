package com.h2t.study.concurrent.cooperation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * await方法测试类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/25 16:46
 */
public class AwaitTask implements Runnable {
    /**
     * 锁
     */
    private Lock lock;

    private Condition condition;

    /**
     * 线程标识符
     */
    private int i;

    public AwaitTask(Lock lock, Condition condition, int i) {
        this.lock = lock;
        this.i = i;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            long start = System.currentTimeMillis();
            condition.await();
            System.out.println(String.format("Thread i = %d arose and Cost = %d ", i, System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
