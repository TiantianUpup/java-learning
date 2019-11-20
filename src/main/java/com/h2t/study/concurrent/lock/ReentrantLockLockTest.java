package com.h2t.study.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock lock方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/20 19:40
 */
public class ReentrantLockLockTest {
    public static void main(String[] args) throws InterruptedException {
        //中断测试
        Thread thread = new Thread(new Task(555));
        thread.start();
        Thread.sleep(3 * 1000);
        thread.interrupt();  //睡眠三秒后中断
    }

    private static class Task implements Runnable {
        private static Lock lock = new ReentrantLock();

        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                lockMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //每次只允许一个线程调用
        private void lockMethod() throws InterruptedException {
            lock.lock();
            try {
                Thread.sleep(1000 * 60 * 60 * 24);
                System.out.println(i);
            } finally {
                lock.unlock();
            }
        }
    }
}
