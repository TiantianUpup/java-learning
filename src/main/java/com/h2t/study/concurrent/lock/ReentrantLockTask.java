package com.h2t.study.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock加锁性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/21 18:28
 */
public class ReentrantLockTask implements Runnable {
    ReentrantLock lock = new ReentrantLock();
    private int i;

    public ReentrantLockTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        lockMethod();
    }

    private void lockMethod() {
        int sum = 0;
        lock.lock();
        try {
            for (int j = 0; j < 10; j++) {
                sum += j;
            }

        } finally {
            lock.unlock();
        }
    }
}
