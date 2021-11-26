package dsa.section15;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonacci {

    // 0 , 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public int fibonacciSequenceAsArray(int n) {
        // add extraSpaceFor initial entries 0,1 - handles 0 being passed in
        // if space uses exactly what is needed
        int[] sequence = new int[n + 2];
        sequence[0]=0;
        sequence[1]=1;

        for (int i = 2; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence[n];
    }
    // 0 , 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    // fib is 4 = 3 (zero indexed)
    // fib us 3 = 2 (zero indexed)
    public int fibonacciSequenceAsArrayAlternative(int n) {
        // deal with 0 and 1
        if ( n < 2) {
            return n;
        }
        // n is zero indexed so add additional space
        int max = n + 1;
        int[] sequence = new int[max];
        sequence[0]=0;
        sequence[1]=1;


        // array index 0 1 2 3 ..
        // start at 2 index in array (i = 2) - if n = 2 then
        for (int i = 2; i <= n; i++) {
            int value = sequence[i - 1] + sequence[i - 2];
            sequence[i] = value;
        }
        return sequence[n];
    }

    // 0 , 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public int fibonacciSequenceAsList(int n) {
        if ( n < 2) {
            return n;
        }
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
        return result.get(num);
    }

    private List<Integer> fibonacciSequenceRecursiveList(int num, int count, List<Integer> result) {
        if (count > num) {
            return result;
        }
        result.add(result.get(count - 1) + result.get(count - 2));
        return fibonacciSequenceRecursiveList(num, ++count, result);
    }

    public int fibonacciSequenceSpaceOfNRecursiveArray(int num) {
        int[] sequence  = new int[num + 2];
        sequence[0] = 0;
        sequence[1] = 1;

        int[] result = fibonacciSequenceSpaceOfNRecursiveArray(num, 2, sequence);
        return result[num];
    }

    private int[] fibonacciSequenceSpaceOfNRecursiveArray(int num, int count, int[] result) {
        if (count > num) {
            return result;
        }
        result[count] = result[count - 1] + result[count - 2];
        return fibonacciSequenceSpaceOfNRecursiveArray(num, ++count, result);
    }

    //    fibonacciConstantSpaceRecursive
    public int fibRecursive(int n) {
        if (n < 2) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

}
