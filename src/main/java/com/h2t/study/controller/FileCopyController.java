package com.h2t.study.controller;

import com.h2t.study.io.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件拷贝控制层
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/16 19:10
 */
@RestController
public class FileCopyController {
    private static final String source = "input/23KB.txt";
    private static final String target = "output/copy.txt";

    @GetMapping("/io")
    public Object ioFileCopy() {
        IOFileCopy.copyFile(source, target);
        caculateTask();
        return "success";
    }

    @GetMapping("/nio")
    public Object nioFileCopy() {
        NIOFileCopy.copyFile(source, target);
        caculateTask();
        return "success";
    }

    @GetMapping("/nio/memory")
    public Object nioMemoryFileCopy() {
        NIOFileCopy2.copyFile(source, target);
        //caculateTask();
        return "success";
    }

    @GetMapping("/files")
    public Object filesCopy() {
        FilesCopy.copyFile(source, target);
        caculateTask();
        return "success";
    }

    @GetMapping("/file_utils")
    public Object fileUtilsCopy() {
        FileUtilsCopy.copyFile(source, target);
        caculateTask();
        return "success";
    }

    private void caculateTask() {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
    }
}
