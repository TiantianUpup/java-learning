package com.h2t.study.builder;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/27 17:05
 */
public class Person {
    private final String name;
    private final int age;

    private final String address;
    private final String phone;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    @Override
    public String toString() {
        return "name:" + name + " age:" + age + " address:" + address + " phone:" + phone;
    }

    public static class Builder {
        private final String name;
        private final int age;

        private String address = null;
        private String phone = null;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Person builder() {
            return new Person(this);
        }
    }

}
