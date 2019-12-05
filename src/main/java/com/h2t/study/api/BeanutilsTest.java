package com.h2t.study.api;

import com.h2t.study.api.model.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        //System.out.println(userDTO);

        //init List
        List<UserPO> userPOList = new ArrayList<>();
        UserPO userPO1 = new UserPO();
        userPO1.setId(1L);
        userPO1.setName("h2t1");
        userPO1.setDeleted(1);
        userPO1.setGmtCreate(System.currentTimeMillis());
        userPO1.setGmtModified(System.currentTimeMillis());

        UserPO userPO2 = new UserPO();
        userPO2.setId(2L);
        userPO2.setName("h2t2");
        userPO2.setDeleted(1);
        userPO2.setGmtCreate(System.currentTimeMillis());
        userPO2.setGmtModified(System.currentTimeMillis());
        userPOList.add(userPO1);
        userPOList.add(userPO2);

        DateAndListDTO dateAndListDTO = new DateAndListDTO();
        dateAndListDTO.setLocalDateTime(LocalDateTime.now());
        dateAndListDTO.setUserPOList(userPOList);

        //value copy
        DateAndListVO dateAndListVO = new DateAndListVO();
        BeanUtils.copyProperties(dateAndListDTO, dateAndListVO);
        System.out.println(dateAndListVO);

//        //modify dateAndListVO
//        dateAndListVO.getUserPOList().get(1).setName("htt");
//        //print dateAndListVO and dateAndListDTO
//        System.out.println("DateAndListDTO: " + dateAndListDTO.getUserPOList().get(1));
//        System.out.println("DateAndListVO: " + dateAndListVO.getUserPOList().get(1));
    }
}
