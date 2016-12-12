package org.home.demo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by andrey on 11.12.16.
 */
public class LambdaDemo {
    Predicate<Integer> odd = value -> value % 2 == 1;
    Predicate<Integer> even = value -> value % 2 == 0;

    public Pair<Integer, Integer> calcOvenEven(Integer[] numbers){
        List<Integer> odds = Arrays.stream(numbers).filter(odd).collect(Collectors.toList());
        List<Integer> evens = Arrays.stream(numbers).filter(even).collect(Collectors.toCollection(ArrayList::new));
        Integer o = odds.stream().reduce(0, (x, y) -> x + y);
        Integer e = evens.stream().reduce(0, Integer::sum);

        return new Pair<Integer, Integer>(o, e);
    }
}
