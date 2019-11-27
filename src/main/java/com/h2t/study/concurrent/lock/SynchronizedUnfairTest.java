package com.h2t.study.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized非公平锁实现
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/26 20:54
 */
public class SynchronizedUnfairTest {
    public static void main(String[] args) {
        ExecutorService unfairEs = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            unfairEs.execute(new UnfairTask(i));
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
        public synchronized void run() {
            System.out.println(String.format("unfairTask i = %d is running", i));
        }
    }
}
