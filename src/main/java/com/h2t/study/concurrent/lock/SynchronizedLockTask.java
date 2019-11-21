package com.h2t.study.concurrent.lock;

/**
 * synchronized加锁性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/21 18:28
 */
public class SynchronizedLockTask implements Runnable {
    private int i;

    public SynchronizedLockTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        lockMethod();
    }

    private synchronized void lockMethod() {
        int sum = 0;

        for (int j = 0; j < 10; j++) {
            sum += j;
        }
    }
}
