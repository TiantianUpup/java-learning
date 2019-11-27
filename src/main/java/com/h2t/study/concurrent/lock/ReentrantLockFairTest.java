package com.h2t.study.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock可以实现公平锁和非公平锁
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/26 20:38
 */
public class ReentrantLockFairTest {
    //通过传入true创建一个公平锁
    private static Lock fairLock = new ReentrantLock(true);
    //非公平锁，默认为非公平锁
    private static Lock unfairLock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService unfairEs = Executors.newCachedThreadPool();
        ExecutorService fairEs = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            unfairEs.execute(new UnfairTask(i));
            fairEs.execute(new FairTask(i));
        }
    }

    /**
     * 非公平锁任务
     */
    private static class UnfairTask implements Runnable {
        private int i;

        public UnfairTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            unfairLock.lock();
            try {
                System.out.println(String.format("unfairTask i = %d is running", i));
            } finally {
                unfairLock.unlock();
            }
        }
    }

    /**
     * 公平锁任务
     */
    private static class FairTask implements Runnable {
        private int i;

        public FairTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            fairLock.lock();
            try {
                System.out.println(String.format("fairTask i = %d is running", i));
            } finally {
                fairLock.unlock();
            }
        }
    }
}
