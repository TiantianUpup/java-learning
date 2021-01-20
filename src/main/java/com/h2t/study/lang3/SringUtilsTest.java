package com.h2t.study.lang3;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/12/30 14:29
 */
public class SringUtilsTest {
    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(""));  //true
        System.out.println(StringUtils.isEmpty("  "));  //false
        System.out.println(StringUtils.isNotEmpty(""));  //false

        System.out.println(StringUtils.isBlank(""));  //true
        System.out.println(StringUtils.isBlank(" "));  //true
        System.out.println(StringUtils.isNotBlank(" "));  //false


        List<Integer> emptyList = new ArrayList<>();
        List<Integer> nullList = null;
        List<Integer> notEmptyList = new ArrayList<>();
        notEmptyList.add(1);
        //CollectionUtils.isEmpty
        System.out.println(CollectionUtils.isEmpty(emptyList));   //true
        System.out.println(CollectionUtils.isEmpty(nullList));   //true
        System.out.println(CollectionUtils.isEmpty(notEmptyList));   //false

        //CollectionUtils.isNotEmpty
        System.out.println(CollectionUtils.isNotEmpty(emptyList));   //false
        System.out.println(CollectionUtils.isNotEmpty(nullList));   //false
        System.out.println(CollectionUtils.isNotEmpty(notEmptyList));   //true
    }
}
