package com.h2t.study.stream;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 流性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/12/05 18:42
 */
public class StreamPerformTest {
    public static void main(String[] args) {
        int times = 10000000;  //累加次数
        ForSum forSum = new ForSum();
        System.out.println("For循环求和耗时: " + measureSumPerf(forSum, times));
        ParallelStreamSum parallelStreamSum = new ParallelStreamSum();
        System.out.println("并行流耗时: " + measureSumPerf(parallelStreamSum, times));
        SequentialStreamSum sequentialStreamSum = new SequentialStreamSum();
        System.out.println("顺序流耗时: " + measureSumPerf(sequentialStreamSum, times));
    }

    /**
     * 性能测试方法
     *
     * @param adder
     * @param n     累加次数
     * @return 最快执行时间
     */
    private static long measureSumPerf(Function<Integer, Integer> adder, int n) {
        //记录最快执行的时间
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            adder.apply(n);
            long duration = System.currentTimeMillis() - start;
            fastest = duration > fastest ? fastest : duration;
        }
        return fastest;
    }

    /**
     * 通过for循环求和
     */
    private static class ForSum implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer integer) {
            int sum = 0;
            for (int i = 1; i <= integer; i++) {
                sum += i;
            }
            return sum;
        }
    }

    /**
     * 并行流求和
     */
    private static class ParallelStreamSum implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer integer) {
            return Stream.iterate(1, i -> i + 1)
                    .limit(integer)  //累加次数
                    .parallel() //转并行流
                    .reduce(0, Integer::sum);  //求和
        }
    }

    /**
     * 顺序流求和
     */
    private static class SequentialStreamSum implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer integer) {
            //默认为顺序流
            return Stream.iterate(1, i -> i + 1)
                    .limit(integer)  //累加次数
                    .reduce(0, Integer::sum);  //求和
        }
    }
}
