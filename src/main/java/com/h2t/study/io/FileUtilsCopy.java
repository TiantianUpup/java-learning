package com.h2t.study.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * FileUtils#copyFile方法进行文件拷贝
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/16 14:48
 */
public class FileUtilsCopy {

    public static void copyFile(String source, String target) {
        long start = System.currentTimeMillis();
        try {
            FileUtils.copyFile(new File(source), new File(target));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("FileUtils file copy cost %d msc", System.currentTimeMillis() - start));
        File targetFile = new File(target);
        targetFile.delete();
    }
}
