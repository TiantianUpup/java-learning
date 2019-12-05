package com.h2t.study.api.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 包含Date、List字段的实体类
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/05 9:50
 */
public class DateAndListDTO {
    private LocalDateTime localDateTime;

    private List<UserPO> userPOList;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public List<UserPO> getUserPOList() {
        return userPOList;
    }

    public void setUserPOList(List<UserPO> userPOList) {
        this.userPOList = userPOList;
    }

    @Override
    public String toString() {
        return "DateAndListDTO{" +
                "localDateTime=" + localDateTime +
                ", userPOList=" + userPOList +
                '}';
    }
}
