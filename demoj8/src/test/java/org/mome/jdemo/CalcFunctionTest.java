package org.mome.jdemo;

import javafx.util.Pair;
import org.home.demo.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.math.BigDecimal;
import java.util.*;
import java.util.function.*;

import static org.openjdk.jmh.annotations.Scope.Group;
import static org.testng.Assert.assertEquals;


/**
 * Created by andrey on 08.12.16.
 */

public class CalcFunctionTest {
    Integer[] numbers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    private List<Integer> numbersList;

    @BeforeClass
    public void setUpClass() {
        numbersList = new ArrayList<>();
        for (int i = 1; i < 100000; i++) {
            numbersList.add(BigDecimal.valueOf(Math.random() * 1000).intValue());
        }
        System.out.println("finish init class");
    }

    Function<Integer, Integer> ddouble = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer val) {
            return val * 2;
        }
    };

    @Test
    public void calculation() {
        CalcFunction cf = (a, b) -> a + b;
        assertEquals(11, cf.calc(3, 8));
    }

    @Test
    public void lambda1() {
        Pair<Integer, Integer> integerPair = new LambdaDemo().calcOvenEven(numbers);
        assertEquals(Integer.valueOf(25), integerPair.getKey());
        assertEquals(Integer.valueOf(20), integerPair.getValue());

    }

    @Test
    public void sumByExtra() {
        assertEquals(45, new SumByExtra().calcOvenEven(numbers).intValue());
    }

    @Test
    public void sumStream() {
        assertEquals(45, new SumStream().calcOvenEven(numbers).intValue());
    }

    @Test
    public void consumer() {
        Consumer<Integer> consumer = (val) -> System.out.println(val);
        consumer.accept(23);
    }

    @Test
    public void stream() {
        new SumEOByExtra().calcOddsEvens(numbersList);
    }

    @Test
    public void parallel() {
        new SumEOByExtraParallel().calcOddsEvens(numbersList);
    }
}
