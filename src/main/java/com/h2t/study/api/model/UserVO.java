package com.h2t.study.api.model;

/**
 * 用户VO
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/04 18:07
 */
public class UserVO {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
