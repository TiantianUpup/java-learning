package com.h2t.study.io;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO流实现文件拷贝【内存映射】
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/16 18:46
 */
public class NIOFileCopy2 {

    public static void copyFile(String source, String target) {
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(new File(source));
             FileOutputStream fos = new FileOutputStream(new File(target))) {
            FileChannel sourceChannel = fis.getChannel();
            FileChannel targetChannel = fos.getChannel();
            MappedByteBuffer mappedByteBuffer = sourceChannel.map(FileChannel.MapMode.READ_ONLY, 0, sourceChannel.size());
            targetChannel.write(mappedByteBuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("NIO memory reflect file copy cost %d msc", System.currentTimeMillis() - start));
        File targetFile = new File(target);
        targetFile.delete();
    }
}
