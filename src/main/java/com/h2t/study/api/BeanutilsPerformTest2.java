package com.h2t.study.api;

import com.h2t.study.api.model.UserPO;
import com.h2t.study.api.model.UserVO2;
import org.springframework.beans.BeanUtils;

/**
 * Beanutils性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/04 18:48
 */
public class BeanutilsPerformTest2 {
    public static void main(String[] args) {
        UserPO userPO = new UserPO();
        userPO.setId(1L);
        userPO.setName("h2t");
        userPO.setDeleted(1);
        userPO.setGmtCreate(System.currentTimeMillis());
        userPO.setGmtModified(System.currentTimeMillis());
        UserVO2 userVO = new UserVO2();
        //值拷贝
        long start = System.currentTimeMillis();
        BeanUtils.copyProperties(userPO, userVO);
        System.out.println("BeanUtils.copyProperties cost: " + (System.currentTimeMillis() - start));

        UserVO2 userVO1 = new UserVO2();
        long start1 = System.currentTimeMillis();
        userVO1.setName(userPO.getName());
        userVO1.setId(userPO.getId());
        userVO1.setDeleted(userPO.getDeleted());
        userVO1.setGmtCreate(userPO.getGmtCreate());
        userVO1.setGmtModified(userPO.getGmtModified());
        System.out.println("get and set copyProperties cost: " + (System.currentTimeMillis() - start1));
    }
}
