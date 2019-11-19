package com.h2t.study.concurrent.interrupt;

/**
 * synchronized阻塞
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/19 17:56
 */
public class SynchronizedBlock implements Runnable {

    /**
     * 构造函数
     */
    public SynchronizedBlock() {
        new Thread() {
            public void run() {
                f();
            }
        }.start();
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlock synchronizedBlock = new SynchronizedBlock();
        Thread thread = new Thread(synchronizedBlock);
        thread.start();
        Thread.sleep(3 * 1000);  //执行三秒后中断线程
        thread.interrupt();
    }

    public synchronized void f() {
        int i = 0;
        while (true) {
            System.out.println(i++);
        }
    }

    @Override
    public void run() {
        f();
        System.out.println("End");
    }

}
