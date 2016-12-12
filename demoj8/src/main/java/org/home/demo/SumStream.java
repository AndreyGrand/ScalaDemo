package org.home.demo;

import java.util.Arrays;

/**
 * Created by andrey on 11.12.16.
 */
public class SumStream {
    public Integer calcOvenEven(Integer[] numbers){
        return Arrays.stream(numbers).mapToInt(Integer::intValue).sum();
    }
}
