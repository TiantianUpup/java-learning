package com.h2t.study.concurrent.cooperation;

import java.util.List;

/**
 * notifyAll方法任务类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/25 16:33
 */
public class NotifyAllTask implements Runnable {
    private List<String> strList;

    public NotifyAllTask(List<String> strList) {
        this.strList = strList;
    }

    @Override
    public void run() {
        synchronized (strList) {
            System.out.println("Wake up thread after 3000 milliSecond");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            strList.notifyAll();
        }
    }
}
