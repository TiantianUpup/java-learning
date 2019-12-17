package com.h2t.study.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture类thenAccept方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/17 19:34
 */
public class ThenAcceptTest {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(ThenAcceptTest::getList).thenAccept(strList -> strList.stream()
                .forEach(m -> System.out.println(m)));
    }

    public static List<String> getList() {
        return Arrays.asList("a", "b", "c");
    }
}
