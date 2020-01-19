package com.h2t.study.io;

/**
 * 文件拷贝性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/16 14:37
 */
public class PerformTest {

    //    private static final String source1 = "input/9KB.txt";
    private static final String source = "input/1MB.rar";
    //    private static final String source2 = "input/test2.txt";
//    private static final String source3 = "input/test3.txt";
//    private static final String source4 = "input/test4.txt";
//    private static final String source5 = "input/test5.txt";
    private static final String target = "output/copy.rar";

    public static void main(String[] args) {
        IOFileCopy.copyFile(source, target);
        NIOFileCopy.copyFile(source, target);
        NIOFileCopy2.copyFile(source, target);
        FilesCopy.copyFile(source, target);
        FileUtilsCopy.copyFile(source, target);

    }
}
