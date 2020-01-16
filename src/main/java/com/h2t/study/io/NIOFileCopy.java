package com.h2t.study.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * NIO流实现文件拷贝
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/16 14:43
 */
public class NIOFileCopy {

    public static void copyFile(String source, String target) {
        long start = System.currentTimeMillis();
        try (FileChannel input = new FileInputStream(new File(source)).getChannel();
             FileChannel output = new FileOutputStream(new File(target)).getChannel()) {
            output.transferFrom(input, 0, input.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(String.format("NIO file copy cost %d msc", System.currentTimeMillis() - start));
    }
}
