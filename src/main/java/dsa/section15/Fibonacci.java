package dsa.section15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {
    public int fibonacciSequence(int n) {
        if ( n <= 2) {
            return 1;
        }
        int max = n + 1;
        int[] sequence = new int[max];
        sequence[0]=0;
        sequence[1]=1;

        for (int i = 2; i < max; i++) {
            int value = sequence[i - 1] + sequence[i - 2];
            sequence[i] = value;
        }
        return sequence[n];
    }
    // 0 , 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public int fibonacciSequenceAsList(int n) {

        List<Integer> sequence = Stream.of(0,1).collect(Collectors.toList());

        for ( int i = 2; i <= n; i++) {
            int value = sequence.get(i - 1) + sequence.get(i - 2);
            sequence.add(value);
        }
        int last = sequence.size() - 1;
        return sequence.get(last);
    }


}
