package com.h2t.study.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock tryLock方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/20 18:32
 */
public class ReentrantLockTryLockTest {
    public static void main(String[] args) throws InterruptedException {
        //定时获取锁测试
//        ExecutorService es = Executors.newCachedThreadPool();
//        for (int i = 0; i < 2; i++) {
//            es.execute(new SleepTask(i));
//        }

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
            long start = System.currentTimeMillis();
            //2s内获得锁
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                System.out.println(String.format("i = %d 获取到锁，耗时：%d", i, System.currentTimeMillis() - start));
                try {
                    Thread.sleep(1000 * 60 * 1);  //睡眠1分钟
                } finally {
                    lock.unlock();
                }

            } else {
                System.out.println(String.format("i = %d 获取到锁失败，耗时：%d", i, System.currentTimeMillis() - start));
            }
        }
    }
}
