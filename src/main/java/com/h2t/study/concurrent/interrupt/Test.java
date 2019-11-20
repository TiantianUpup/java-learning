package com.h2t.study.concurrent.interrupt;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/20 19:31
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //中断测试
        Thread thread = new Thread(new Task(555));
        thread.start();
        Thread.sleep(3 * 1000);
        thread.interrupt();  //睡眠三秒后中断
    }

    private static class Task implements Runnable {
        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                synchronizedMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private synchronized void synchronizedMethod() throws InterruptedException {
            Thread.sleep(1000 * 60 * 60 * 24);
            System.out.println("End...");
        }
    }
}
