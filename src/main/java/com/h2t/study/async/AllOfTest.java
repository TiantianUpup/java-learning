package com.h2t.study.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture类allOf方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/18 16:25
 */
public class AllOfTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello");
            return null;
        });
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("world");
            return null;
        });
        CompletableFuture<Void> result = CompletableFuture.allOf(future1, future2);
        System.out.println(result.get());
    }
}
