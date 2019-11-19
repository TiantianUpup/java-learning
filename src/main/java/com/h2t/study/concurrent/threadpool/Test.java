package com.h2t.study.concurrent.threadpool;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/11/18 11:35
 */
public class Test {
    public static void main(String[] args) {
        TrackingExecutorService trackingExecutorService = new TrackingExecutorService();
        trackingExecutorService.start();
        trackingExecutorService.stop();
        trackingExecutorService.getRunnableList().stream().forEach(i -> System.out.println("Runnable unfinished: " + i));
    }
}
