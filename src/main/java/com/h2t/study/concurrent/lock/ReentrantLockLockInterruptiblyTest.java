package com.h2t.study.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lockInterruptibly方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/25 10:17
 */
public class ReentrantLockLockInterruptiblyTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
        thread.start();
        Thread.sleep(3 * 1000);  //执行三秒后中断线程
        thread.interrupt();
    }

    public static class Task implements Runnable {
        Lock lock = new ReentrantLock();

        public Task() {
            new Thread(() -> {
                try {
                    lockMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        @Override
        public void run() {
            try {
                lockMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End...");
        }

        private void lockMethod() throws InterruptedException {
            lock.lockInterruptibly();
            try {
                //模拟长时间不释放锁
                while (true) {
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
