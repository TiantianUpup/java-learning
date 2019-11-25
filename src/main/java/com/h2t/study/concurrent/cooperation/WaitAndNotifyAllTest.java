package com.h2t.study.concurrent.cooperation;

import java.util.ArrayList;
import java.util.List;

/**
 * wait方法和notifyAll方法的测试类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/25 16:13
 */
public class WaitAndNotifyAllTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        new Thread(new WaitTask(strList, 1)).start();
        new Thread(new WaitTask(strList, 2)).start();
        new Thread(new WaitTask(strList, 3)).start();
        new Thread(new WaitTask(strList, 4)).start();
        new Thread(new NotifyAllTask(strList)).start();
    }
}
