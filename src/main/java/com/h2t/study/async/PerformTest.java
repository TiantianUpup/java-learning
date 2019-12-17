package com.h2t.study.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * 性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/06 18:40
 */
public class PerformTest {
    /**
     * 查找商品的名称
     */
    private static final String PRODUCT_NAME = "myPhone27s";
    /**
     * 店铺信息初始化
     */
    private static List<Shop> shopList = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll")
    );

    public static void main(String[] args) {
        findPriceSyncTest(PRODUCT_NAME);
        findPriceParallelTest(PRODUCT_NAME);
        findPriceAsyncTest(PRODUCT_NAME);
    }

    /**
     * 顺序执行返回所有店铺指定商品的价格
     *
     * @param product
     * @return
     */
    private static List<String> findPriceSync(String product) {
        return shopList.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))  //格式转换
                .collect(Collectors.toList());
    }

    private static void findPriceSyncTest(String product) {
        long start = System.currentTimeMillis();
        findPriceSync(product);
        long end = System.currentTimeMillis();
        System.out.println("Find Price Sync Done in " + (end - start));
    }

    /**
     * 并行流执行返回所有店铺指定商品的价格
     *
     * @param product
     * @return
     */
    private static List<String> findPriceParallel(String product) {
        return shopList.parallelStream()  //转换为并行流
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))  //格式转换
                .collect(Collectors.toList());
    }

    private static void findPriceParallelTest(String product) {
        long start = System.currentTimeMillis();
        findPriceParallel(product);
        long end = System.currentTimeMillis();
        System.out.println("Find Price Parallel Done in " + (end - start));
    }

    /**
     * 执行返回所有店铺指定商品的价格
     *
     * @param product
     * @return
     */
    private static List<String> findPriceAsync(String product) {
        List<CompletableFuture<String>> completableFutureList = shopList.stream()
                //转异步执行
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> String.format("%s price is %.2f",
                                shop.getName(), shop.getPrice(product))))  //格式转换
                .collect(Collectors.toList());

        return completableFutureList.stream()
                .map(CompletableFuture::join)  //获取结果不会抛出异常
                .collect(Collectors.toList());
    }

    private static void findPriceAsyncTest(String product) {
        long start = System.currentTimeMillis();
        findPriceAsync(product);
        long end = System.currentTimeMillis();
        System.out.println("Find Price Async Done in " + (end - start));
    }
}
