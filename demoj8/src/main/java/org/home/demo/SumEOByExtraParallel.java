package org.home.demo;

import javafx.util.Pair;

import java.util.List;

/**
 * Created by andrey on 11.12.16.
 */
public class SumEOByExtraParallel extends SumEOByExtra {
    @Override
    public Pair<Integer, Integer> calcOddsEvens(List<Integer> numbers){
        SummEvenAndOdds summEvenAndOdds = numbers.parallelStream().collect(SummEvenAndOdds::new, SummEvenAndOdds::accept, SummEvenAndOdds::combine);
        System.out.println(summEvenAndOdds.toString());
        return new Pair<>(summEvenAndOdds.oddSum, summEvenAndOdds.evenSum);
    }

}
