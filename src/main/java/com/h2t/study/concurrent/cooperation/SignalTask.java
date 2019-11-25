package com.h2t.study.concurrent.cooperation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Signal方法任务类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/25 16:47
 */
public class SignalTask implements Runnable {
    /**
     * 锁
     */
    private Lock lock;

    private Condition condition;


    public SignalTask(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("Wake up thread after 3000 milliSecond");
            Thread.sleep(3000);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
