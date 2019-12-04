package com.h2t.study.api;

import com.h2t.study.api.model.UserDTO;
import com.h2t.study.api.model.UserPO;
import com.h2t.study.api.model.UserVO;
import org.springframework.beans.BeanUtils;

/**
 * Beanutils方法测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/04 18:03
 */
public class BeanutilsTest {
    public static void main(String[] args) {
        UserPO userPO = new UserPO();
        userPO.setId(1L);
        userPO.setName("h2t");
        userPO.setDeleted(1);
        userPO.setGmtCreate(System.currentTimeMillis());
        userPO.setGmtModified(System.currentTimeMillis());
        UserVO userVO = new UserVO();
        //值拷贝
        BeanUtils.copyProperties(userPO, userVO);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userVO, userDTO);
        System.out.println(userDTO);
    }
}
