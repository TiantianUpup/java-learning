package com.h2t.study.builder;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/27 17:13
 */
public class Test {
    public static void main(String[] args) {
        new FileSetPO.Builder().size(12).build();
        new FileSetPO.Builder().status(1).build();
        new FileSetPO.Builder().status(1).size(12).build();
    }
}
