package com.h2t.study.concurrent.atomic;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * AtomicLong和LongAdder的性能测试
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/20 14:19
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class PerformaceTest {
    private static AtomicLong atomicLong = new AtomicLong();
    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(PerformaceTest.class.getSimpleName()).build();
        new Runner(options).run();
    }

    @Benchmark
    @Threads(5)
    public void atomicLongAdd() {
        atomicLong.getAndIncrement();
    }

    @Benchmark
    @Threads(5)
    public void longAdderAdd() {
        longAdder.increment();
    }
}
