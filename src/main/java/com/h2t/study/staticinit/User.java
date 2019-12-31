package com.h2t.study.staticinit;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/19 18:00
 */
public class User {
    static final User user;

    //初始化
    static {
        user = new User("h2t");
    }

    private String name;

    public User(String name) {
        this.name = name;
        System.out.println("init...");
    }

    public static User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "FileSetPO{" +
                "name='" + name + '\'' +
                '}';
    }
}
