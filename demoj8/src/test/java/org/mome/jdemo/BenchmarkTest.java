package org.mome.jdemo;

import org.home.demo.SumEOByExtra;
import org.home.demo.SumEOByExtraParallel;
import org.home.demo.SumStream;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrey on 12.12.16.
 */
@State(Scope.Benchmark)
public class BenchmarkTest {
    private List<Integer> numbersList;
    private Integer[] numbers;

    @Setup(Level.Trial)
    public void initialize()
    {
        numbersList = new ArrayList<>();
        for (int i = 1; i < 100000; i++) {
            numbersList.add(BigDecimal.valueOf(Math.random() * 1000).intValue());
        }
        numbers = new Integer[numbersList.size()];
        numbersList.toArray(numbers);
    }

    @Benchmark
    @BenchmarkMode({/*Mode.Throughput,*/ Mode.AverageTime/*, Mode.SampleTime*/})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public Integer testStream(){
        return new SumEOByExtra().calcOddsEvens(numbersList).getKey() + new SumEOByExtra().calcOddsEvens(numbersList).getValue();
    }
    @Benchmark
    @BenchmarkMode({/*Mode.Throughput,*/ Mode.AverageTime/*, Mode.SampleTime*/})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public Integer testStreamParalel(){
        return new SumEOByExtraParallel().calcOddsEvens(numbersList).getKey() + new SumEOByExtraParallel().calcOddsEvens(numbersList).getValue();
    }

    @Benchmark
    @BenchmarkMode({/*Mode.Throughput,*/ Mode.AverageTime/*, Mode.SampleTime*/})
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public Integer testSum(){
        return new SumStream().calcOvenEven(numbers);
    }


    public static void main(final String[] _args)
            throws RunnerException
    {
        Options opt = new OptionsBuilder()
                .include(".*" + "Benchmark" + ".*")
                         .warmupTime(TimeValue.seconds(1))
            .warmupIterations(5)
            .measurementTime(TimeValue.seconds(1))
            .measurementIterations(5)
            .threads(1)
            .forks(1)
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .jvmArgs("-server")
                         .build();

        new Runner(opt).run();
    }
}
