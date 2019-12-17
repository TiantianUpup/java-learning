package com.h2t.study.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture类thenApply方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/17 18:16
 */
public class ThenApplyTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(ThenApplyTest::randomInteger).thenApply((i) -> i * 8);
        System.out.println(result.get());
    }

    public static Integer randomInteger() {
        return 10;
    }
}
