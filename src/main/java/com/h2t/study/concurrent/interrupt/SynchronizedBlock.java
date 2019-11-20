package com.h2t.study.concurrent.interrupt;

/**
 * synchronized阻塞
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/19 17:56
 */
public class SynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
        thread.start();
        Thread.sleep(3 * 1000);  //执行三秒后中断线程
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }

    public static class Task implements Runnable {
        public Task() {
            new Thread() {
                public void run() {
                    f();
                }
            }.start();
        }

        public synchronized void f() {
            while (true) {
            }
        }

        @Override
        public void run() {
            f();
            System.out.println("End");
        }
    }
}
