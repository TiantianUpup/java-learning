package com.h2t.study.concurrent.interrupt;

import java.io.IOException;
import java.io.InputStream;

/**
 * IO阻塞方法中断
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/20 14:37
 */
public class IOBlockInterrupt {
    public static void main(String[] args) {
        MyThread thread = new MyThread(System.in);  //输入流的来源来自用户输入
        thread.start();
        thread.interrupt();
    }


    private static class MyThread extends Thread {
        private InputStream inputStream;

        public MyThread(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        //重写interrupt方法
        @Override
        public void interrupt() {
            //1.关闭流
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //2.调用中断方法
                super.interrupt();
            }
        }

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
