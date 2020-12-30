package com.h2t.study.io;

import java.io.*;

/**
 * IO流实现文件拷贝
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/16 14:36
 */
public class IOFileCopy {

    //private static final int BUFFER_SIZE = 1024;
    private static final int BUFFER_SIZE = 20 * 1024 * 1024;

    public static void copyFile(String source, String target) {
        long start = System.currentTimeMillis();
        try (InputStream in = new FileInputStream(new File(source));
             OutputStream out = new FileOutputStream(new File(target))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }

            System.out.println(String.format("IO file copy cost %d msc", System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }

        File targetFile = new File(target);
        targetFile.delete();
    }
}
