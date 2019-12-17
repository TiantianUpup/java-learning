package com.h2t.study.async;

import java.util.concurrent.*;

/**
 * Future超时重载方法的测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/17 15:30
 */
public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> result = es.submit(new Task());
        //1s内获取结果
        System.out.println(result.get(1, TimeUnit.SECONDS));
    }

    private static class Task implements Callable<Integer> {
        @Override
        public Integer call() {
            long start = System.currentTimeMillis();
            while (true) {
                if (System.currentTimeMillis() - start > 1000 * 60 * 60) {
                    break;
                }
            }

            return 1;
        }
    }
}
