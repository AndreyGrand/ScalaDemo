package org.home.demo;

import javafx.util.Pair;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

/**
 * Created by andrey on 11.12.16.
 */
public class SumEOByExtra {
    private Predicate<Integer> odd = value -> value % 2 == 1;
    private Predicate<Integer> even = value -> value % 2 == 0;

    public Pair<Integer, Integer> calcOddsEvens(List<Integer> numbers){
        SummEvenAndOdds summEvenAndOdds = numbers.stream().collect(SummEvenAndOdds::new, SummEvenAndOdds::accept, SummEvenAndOdds::combine);
        System.out.println(summEvenAndOdds.toString());
        return new Pair<>(summEvenAndOdds.oddSum, summEvenAndOdds.evenSum);
    }

    class SummEvenAndOdds implements IntConsumer {
        protected int oddSum = 0;
        protected int evenSum = 0;



        protected SummEvenAndOdds() {
            System.out.println("Created new SummEvenAndOdds");
        }

        @Override
        public void accept(int value) {
            if(odd.test(value)){
                oddSum += value;
            }
            else if(even.test(value)){
                evenSum += value;
            }
            else{
                throw new IllegalArgumentException("unexpected agrument:" + value);
            }
        }

        public void combine(SummEvenAndOdds other) {
            oddSum += other.oddSum;
            evenSum += other.evenSum;
        }

        @Override
        public String toString() {
            return "SummEvenAndOdds{" +
                    "oddSum=" + oddSum +
                    ", evenSum=" + evenSum +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SummEvenAndOdds that = (SummEvenAndOdds) o;

            if (oddSum != that.oddSum) return false;
            return evenSum == that.evenSum;
        }

        @Override
        public int hashCode() {
            int result = oddSum;
            result = 31 * result + evenSum;
            return result;
        }
    }
}
