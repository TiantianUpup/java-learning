package com.h2t.study.concurrent.cooperation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * await和signal方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/25 17:49
 */
public class AwaitAndSignalTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new AwaitTask(lock, condition, 1)).start();
        new Thread(new AwaitTask(lock, condition, 2)).start();
        new Thread(new AwaitTask(lock, condition, 3)).start();
        new Thread(new AwaitTask(lock, condition, 4)).start();
        new Thread(new SignalTask(lock, condition)).start();
    }
}
