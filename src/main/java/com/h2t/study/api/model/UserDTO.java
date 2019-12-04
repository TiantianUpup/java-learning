package com.h2t.study.api.model;

/**
 * 用户DTO类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/04 18:14
 */
public class UserDTO {
    private Long userDTOId;

    private String name;

    public Long getUserDTOId() {
        return userDTOId;
    }

    public void setUserDTOId(Long userDTOId) {
        this.userDTOId = userDTOId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userDTOId=" + userDTOId +
                ", name='" + name + '\'' +
                '}';
    }
}
