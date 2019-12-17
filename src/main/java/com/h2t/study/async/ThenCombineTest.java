package com.h2t.study.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture类thenCombine方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/17 16:30
 */
public class ThenCombineTest {
    private static Random random = new Random();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(ThenCombineTest::randomInteger).thenCombine(
                CompletableFuture.supplyAsync(ThenCombineTest::randomInteger), (i, j) -> i * j
        );

        System.out.println(result.get());
    }

    public static Integer randomInteger() {
        return random.nextInt(100);
    }
}
