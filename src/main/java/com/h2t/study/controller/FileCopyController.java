package com.h2t.study.controller;

import com.h2t.study.io.FileUtilsCopy;
import com.h2t.study.io.FilesCopy;
import com.h2t.study.io.IOFileCopy;
import com.h2t.study.io.NIOFileCopy;
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
    private static final String source1 = "input/test1.txt";
    private static final String source2 = "input/test2.txt";
    private static final String source3 = "input/test3.txt";
    private static final String source4 = "input/test4.txt";
    private static final String target1 = "output/test1.txt";
    private static final String target2 = "output/test2.txt";
    private static final String target3 = "output/test3.txt";
    private static final String target4 = "output/test4.txt";

    @GetMapping("/io")
    public Object ioFileCopy() {
        IOFileCopy.copyFile(source1, target1);
        caculateTask();
        return "success";
    }

    @GetMapping("/nio")
    public Object nioFileCopy() {
        NIOFileCopy.copyFile(source2, target2);
        caculateTask();
        return "success";
    }

    @GetMapping("/files")
    public Object filesCopy() {
        FilesCopy.copyFile(source3, target3);
        caculateTask();
        return "success";
    }

    @GetMapping("/file_utils")
    public Object fileUtilsCopy() {
        FileUtilsCopy.copyFile(source4, target4);
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
