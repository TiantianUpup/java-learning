package com.h2t.study.concurrent.cooperation;

import java.util.List;

/**
 * wait方法任务
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/25 16:09
 */
public class WaitTask implements Runnable {
    private List<String> strList;

    /**
     * 用于标识线程
     */
    private int i;

    public WaitTask(List<String> strList, int i) {
        this.strList = strList;
        this.i = i;
    }

    @Override
    public void run() {
        synchronized (strList) {
            try {
                long start = System.currentTimeMillis();
                strList.wait();
                System.out.println(String.format("Thread i = %d arose and Cost = %d ", i, System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
