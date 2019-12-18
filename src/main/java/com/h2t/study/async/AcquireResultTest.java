package com.h2t.study.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture类结果获取方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/18 19:06
 */
public class AcquireResultTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //getNow方法测试
        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(60 * 1000 * 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "hello world";
        });

        System.out.println(cp1.getNow("hello h2t"));

        //join方法测试
//        CompletableFuture<Integer> cp2 = CompletableFuture.supplyAsync((()-> 1 / 0));
//        System.out.println(cp2.join());

        //get方法测试
        CompletableFuture<Integer> cp3 = CompletableFuture.supplyAsync((() -> 1 / 0));
        System.out.println(cp3.get());
    }
}
