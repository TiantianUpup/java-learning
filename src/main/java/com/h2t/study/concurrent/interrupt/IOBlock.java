package com.h2t.study.concurrent.interrupt;

import java.io.IOException;
import java.io.InputStream;

/**
 * IO阻塞
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/19 17:57
 */
public class IOBlock {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new IOTask(System.in));  //输入流的来源来自用户输入
        thread.start();
        //Thread.sleep(3 * 1000);  //睡眠3s
        thread.interrupt();
        //System.out.println("是否被中断：" + thread.isInterrupted());
        //System.out.println("中断已执行");
    }

    public static class IOTask implements Runnable {
        private InputStream inputStream;

        public IOTask(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        /**
         * 自定义任务
         */
        @Override
        public void run() {
            try {
                inputStream.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("End...");
        }
    }
}
