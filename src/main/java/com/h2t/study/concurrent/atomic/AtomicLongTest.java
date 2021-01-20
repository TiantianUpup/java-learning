package com.h2t.study.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * AtomicLongTest
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/20 10:19
 */
public class AtomicLongTest {
    private static final int THREAD_COUNT = 20;

    private static volatile AtomicLong race = new AtomicLong(0);

    public static void increase() {
        race.getAndIncrement();
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

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("race: " + race);
    }
}
