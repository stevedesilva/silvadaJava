package dsa.section15;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonacci {
    public int fibonacciSequenceAsArray(int n) {
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
        List<Integer> sequence = Stream.of(0,1).collect(toList());

        for ( int i = 2; i <= n; i++) {
            int value = sequence.get(i - 1) + sequence.get(i - 2);
            sequence.add(value);
        }
        int last = sequence.size() - 1;
        return sequence.get(last);
    }

    public int fibonacciSequenceRecursiveList(int num) {
        List<Integer> result = fibonacciSequenceRecursiveList(num, 2, Stream.of(0,1).collect(toList()));
        int lastIdx = result.size() - 1;
        return result.get(lastIdx);
    }

    private List<Integer> fibonacciSequenceRecursiveList(int num, int count, List<Integer> result) {
        if (count > num) {
            return result;
        }
        result.add(result.get(count - 1) + result.get(count - 2));
        return fibonacciSequenceRecursiveList(num, ++count, result);
    }

    public int fibonacciSequenceRecursiveArray(int num) {
        if (num <= 2) return 1;

        final int max = num + 1;
        int[] sequence  = new int[max];
        sequence[0] = 0;
        sequence[1] = 1;

        int[] result = fibonacciSequenceRecursiveArray(num, 2, sequence);
        int lastIdx = result.length - 1;
        return result[lastIdx];
    }

    private int[] fibonacciSequenceRecursiveArray(int num, int count, int[] result) {
        if (count > num) {
            return result;
        }
        result[count] = result[count - 1] + result[count - 2];
        return fibonacciSequenceRecursiveArray(num, ++count, result);
    }


}
