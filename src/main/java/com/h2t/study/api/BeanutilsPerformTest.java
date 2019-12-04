package com.h2t.study.api;

import com.h2t.study.api.model.UserPO;
import com.h2t.study.api.model.UserVO;
import org.springframework.beans.BeanUtils;

/**
 * Beanutils性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/04 18:36
 */
public class BeanutilsPerformTest {
    public static void main(String[] args) {
        UserPO userPO = new UserPO();
        userPO.setId(1L);
        userPO.setName("h2t");
        userPO.setDeleted(1);
        userPO.setGmtCreate(System.currentTimeMillis());
        userPO.setGmtModified(System.currentTimeMillis());
        UserVO userVO = new UserVO();
        //值拷贝
        long start = System.currentTimeMillis();
        BeanUtils.copyProperties(userPO, userVO);
        System.out.println("BeanUtils.copyProperties cost: " + (System.currentTimeMillis() - start));

        UserVO userVO1 = new UserVO();
        long start1 = System.currentTimeMillis();
        userVO1.setName(userPO.getName());
        userVO1.setId(userPO.getId());
        System.out.println("get and set copyProperties cost: " + (System.currentTimeMillis() - start1));
    }
}
