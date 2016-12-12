package org.home.demo;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by andrey on 11.12.16.
 */
public class SumByExtra {
    public Integer calcOvenEven(Integer[] numbers){
        AddmeImpl a = new AddmeImpl();
        Arrays.stream(numbers).forEach(a);
        return a.result;
    }
    class AddmeImpl implements Consumer<Integer> {
        int result = 0;

        @Override
        public void accept(Integer val) {
            result += val;
        }
    }
}
