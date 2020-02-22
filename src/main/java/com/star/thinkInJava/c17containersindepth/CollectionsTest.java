package com.star.thinkInJava.c17containersindepth;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class CollectionsTest {
    private static final int TEN_MILLION = 10000000;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CollectionsTest.class.getSimpleName()).output("Benchmark.log")
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void arrayList() {
        List<String> array = new ArrayList<>();
        for (int i = 0; i < TEN_MILLION; i++) {
            array.add("123");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void arrayListSize() {
        List<String> array = new ArrayList<>(TEN_MILLION);
        for (int i = 0; i < TEN_MILLION; i++) {
            array.add("123");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void linkedList() {
        List<String> array = new LinkedList<>();
        for (int i = 0; i < TEN_MILLION; i++) {
            array.add("123");
        }
    }
}
