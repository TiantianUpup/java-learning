package com.h2t.study.concurrent.atomic;

/**
 * Volatile关键字测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/20 10:13
 */
public class VolatileTest {
    private static final int THREAD_COUNT = 20;

    private static volatile int race = 0;

    public static synchronized void increase() {
        race++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        //等所有累加线程都结束
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("race: " + race);
    }
}
