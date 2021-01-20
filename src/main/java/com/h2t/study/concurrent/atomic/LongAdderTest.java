package com.h2t.study.concurrent.atomic;

import java.util.concurrent.atomic.LongAdder;

/**
 * LongAdderTest
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/20 14:08
 */
public class LongAdderTest {
    private static final int THREAD_COUNT = 20;

    //默认初始化为0值
    private static volatile LongAdder race = new LongAdder();

    public static void increase() {
        race.increment();
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
