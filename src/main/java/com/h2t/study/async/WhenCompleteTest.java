package com.h2t.study.async;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture类whenComplete方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/18 19:26
 */
public class WhenCompleteTest {
    public static void main(String[] args) {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> cf2 = cf1.whenComplete((v, e) ->
                System.out.println(String.format("value:%s, exception:%s", v, e)));
        System.out.println(cf2.join());
    }
}
