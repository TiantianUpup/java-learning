package com.h2t.study.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * 店铺
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/06 15:35
 */
public class Shop {
    /**
     * 店铺名称
     */
    private String name;

    private Random random = new Random();


    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    /**
     * 根据产品名查找价格
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * 异步查询商品的价格
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        //新启一个线程去执行计算价格的操作
        new Thread(() -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);  //将计算结果保存在CompletableFuture中
        });

        return futurePrice;
    }

    /**
     * 计算价格
     *
     * @param product
     * @return
     */
    private double calculatePrice(String product) {
        delay();
        //random.nextDouble()随机返回折扣
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 通过睡眠模拟其他耗时操作
     */
    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
