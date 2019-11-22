package com.h2t.study.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/22 11:33
 */
public class PerformTest {
    public static void main(String[] args) {
        AtomicLongCalculate atomicLongCalculate = new AtomicLongCalculate();
        SynchronizedLongCalculate synchronizedLongCalculate = new SynchronizedLongCalculate();

        for (int i = 1; i <= 20; i++) {
            atomicLongCalculateTest(i, 1000, atomicLongCalculate);
            synchronizedLongCalculateTest(i, 1000, synchronizedLongCalculate);
        }
    }

    /**
     * @param thread 并发线程数
     * @param time   累加次数
     */
    private static void atomicLongCalculateTest(int thread, int time, AtomicLongCalculate atomicLongCalculate) {
        ExecutorService es = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();

        for (int i = 0; i < time; i++) {
            es.execute(() -> {
                atomicLongCalculate.increamentValue();
            });
        }

        System.out.println(String.format("AtomicLongCalculate Thread nums = %d, time cost = %d, result = %d",
                thread, System.currentTimeMillis() - start, atomicLongCalculate.getValue()));
    }

    private static void synchronizedLongCalculateTest(int thread, int time, SynchronizedLongCalculate synchronizedLongCalculate) {
        ExecutorService es = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();

        for (int i = 0; i < time; i++) {
            es.execute(() -> {
                synchronizedLongCalculate.increamentValue();
            });
        }
        System.out.println(String.format("SynchronizedLongCalculate Thread nums = %d, time cost = %d, result = %d",
                thread, System.currentTimeMillis() - start, synchronizedLongCalculate.getValue()));
    }
}
