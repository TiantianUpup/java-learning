package com.h2t.study.api;

import com.h2t.study.api.model.UserPO;
import com.h2t.study.api.model.UserVO;
import com.h2t.study.api.model.UserVO2;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * PropertyUtilsPerform性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/04 19:25
 */
public class PropertyUtilsPerformTest {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        UserPO userPO = new UserPO();
        userPO.setId(1L);
        userPO.setName("h2t");
        userPO.setDeleted(1);
        userPO.setGmtCreate(System.currentTimeMillis());
        userPO.setGmtModified(System.currentTimeMillis());
        UserVO userVO = new UserVO();
        //值拷贝
        long start = System.currentTimeMillis();
        PropertyUtils.copyProperties(userPO, userVO);
        System.out.println("PropertyUtils.copyProperties cost: " + (System.currentTimeMillis() - start));

        UserVO userVO1 = new UserVO();
        long start1 = System.currentTimeMillis();
        userVO1.setName(userPO.getName());
        userVO1.setId(userPO.getId());
        System.out.println("get and set copyProperties cost: " + (System.currentTimeMillis() - start1));

        UserVO2 userVO2 = new UserVO2();
        long start2 = System.currentTimeMillis();
        userVO2.setName(userPO.getName());
        userVO2.setId(userPO.getId());
        userVO2.setDeleted(userPO.getDeleted());
        userVO2.setGmtCreate(userPO.getGmtCreate());
        userVO2.setGmtModified(userPO.getGmtModified());
        System.out.println("get and set copyProperties cost have same field: " + (System.currentTimeMillis() - start2));
    }
}
