package com.h2t.study.io;

/**
 * 文件拷贝性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2020/01/16 14:37
 */
public class PerformTest {

    private static final String source1 = "input/test1.txt";
    private static final String source2 = "input/test2.txt";
    private static final String source3 = "input/test3.txt";
    private static final String source4 = "input/test4.txt";
    private static final String target1 = "output/test1.txt";
    private static final String target2 = "output/test2.txt";
    private static final String target3 = "output/test3.txt";
    private static final String target4 = "output/test4.txt";

    public static void main(String[] args) {
        IOFileCopy.copyFile(source1, target1);
        NIOFileCopy.copyFile(source2, target2);
        FilesCopy.copyFile(source3, target3);
        FileUtilsCopy.copyFile(source4, target4);
    }
}
