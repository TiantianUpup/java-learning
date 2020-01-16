package com.h2t.study.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Files#copy文件拷贝方法
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/16 14:48
 */
public class FilesCopy {

    public static void copyFile(String source, String target) {
        long start = System.currentTimeMillis();
        try {
            File sourceFile = new File(source);
            File targetFile = new File(target);
            Files.copy(sourceFile.toPath(), targetFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("FileCopy file copy cost %d msc", System.currentTimeMillis() - start));
    }
}
