package com.h2t.study.concurrent.atomic;

/**
 * synchronized加锁对long进行计算测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/22 11:26
 */
public class SynchronizedLongCalculate {
    private long value = 0;

    public synchronized void increamentValue() {
        value++;
    }

    public synchronized long getValue() {
        return value;
    }
}
