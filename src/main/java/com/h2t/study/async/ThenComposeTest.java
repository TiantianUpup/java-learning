package com.h2t.study.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture类thenCompose方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/17 19:46
 */
public class ThenComposeTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(ThenComposeTest::getInteger)
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> i * 10));
        System.out.println(result.get());
    }

    private static int getInteger() {
        return 666;
    }

    private static int expandValue(int num) {
        return num * 10;
    }
}
