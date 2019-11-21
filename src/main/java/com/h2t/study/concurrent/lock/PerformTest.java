package com.h2t.study.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized和ReentrantLock性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/21 18:38
 */
public class PerformTest {
    public static void main(String[] args) {
        for (int i = 100; i < 1000000000; i = i * 10) {
            reentrantLockTest(i);
            synchronizedLockTest(i);
        }
    }

    /**
     * 循环执行的次数
     */
    private static void reentrantLockTest(int time) {
        ExecutorService es = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            es.execute(new ReentrantLockTask(i));
        }

        System.out.println(String.format("ReentrantLockTest time = %d Spend %d", time, System.currentTimeMillis() - start));
    }

    private static void synchronizedLockTest(int time) {
        ExecutorService es = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            es.execute(new SynchronizedLockTask(i));
        }

        System.out.println(String.format("SynchronizedLockTest time = %d Spend %d", time, System.currentTimeMillis() - start));
    }
}
