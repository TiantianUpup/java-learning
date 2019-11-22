package com.h2t.study.concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子类计算测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/22 11:26
 */
public class AtomicLongCalculate {
    private AtomicLong atomicLong = new AtomicLong(0);

    public void increamentValue() {
        atomicLong.getAndIncrement();
    }

    public long getValue() {
        return atomicLong.get();
    }
}
