package com.h2t.study.api;

import com.h2t.study.api.model.UserDTO;
import com.h2t.study.api.model.UserPO;
import com.h2t.study.api.model.UserVO;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * PropertyUtils方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/04 19:12
 */
public class PropertyUtilsTest {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        UserPO userPO = new UserPO();
        userPO.setId(1L);
        userPO.setName("h2t");
        userPO.setDeleted(1);
        userPO.setGmtCreate(System.currentTimeMillis());
        userPO.setGmtModified(System.currentTimeMillis());
        UserVO userVO = new UserVO();
        //值拷贝
        PropertyUtils.copyProperties(userVO, userPO);

        System.out.println("UserVO: " + userVO);

        UserDTO userDTO = new UserDTO();
        PropertyUtils.copyProperties(userDTO, userVO);
        System.out.println("UserDTO: " + userDTO);
    }
}
