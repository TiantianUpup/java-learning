package com.h2t.study.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture类anyOf方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/18 16:25
 */
public class AnyOfTest {
    private static Random random = new Random();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            randomSleep();
            System.out.println("hello");
            return "hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            randomSleep();
            System.out.println("world");
            return "world";
        });
        CompletableFuture<Object> result = CompletableFuture.anyOf(future1, future2);
        System.out.println(result.get());
    }

    private static void randomSleep() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
