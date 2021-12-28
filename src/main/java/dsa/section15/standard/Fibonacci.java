package dsa.section15.standard;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonacci {

    // 0 , 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public int fibonacciSequenceIterativeAsArray(int n) {
        // add extraSpaceFor initial entries 0,1 - handles 0 being passed in
        int[] sequence = new int[n + 2];
        // initialise with 0 and 1
        sequence[0]=0;
        sequence[1]=1;
        // add last two values in array
        for (int i = 2; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        // return last position
        return sequence[n];
    }

    // 0 , 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    // fib is 4 = 3 (zero indexed)
    // fib us 3 = 2 (zero indexed)
    public int fibonacciSequenceIterativeAsArrayAlternative(int n) {
        // return n if less than 2
        if ( n < 2) {
            return n;
        }
        // n is zero indexed so add additional space
        int[] sequence = new int[n + 1];
        // initialise with 0 and 1
        sequence[0]=0;
        sequence[1]=1;

        // add last two entries in array
        for (int i = 2; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        // return last position
        return sequence[n];
    }

    // 0 , 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public int fibonacciSequenceIterativeAsList(int n) {
        // return n if less than 2
        if ( n < 2) {
            return n;
        }
        // initialise list with 0 and 1
        List<Integer> sequence = Stream.of(0,1).collect(toList());
        // add last two values in list
        for ( int i = 2; i <= n; i++) {
            sequence.add(sequence.get(i - 1) + sequence.get(i - 2));
        }
        // return last position in list
        return sequence.get(n);
    }

    public int fibonacciSequenceRecursiveList(int num) {
        List<Integer> result = fibonacciSequenceRecursiveList(num, 2, Stream.of(0,1).collect(toList()));
        return result.get(num);
    }

    private List<Integer> fibonacciSequenceRecursiveList(int num, int count, List<Integer> result) {
        // Base case: return if count greater than num
        if (count > num) {
            return result;
        }
        // add last two values in list
        result.add(result.get(count - 1) + result.get(count - 2));
        // recursive call: increment count
        return fibonacciSequenceRecursiveList(num, ++count, result);
    }

    public int fibonacciSequenceSpaceOfNRecursiveArray(int num) {
        // add extraSpaceFor initial entries 0,1 - handles 0 being passed in
        int[] sequence  = new int[num + 2];
        // init array with 0 & 1
        sequence[0] = 0;
        sequence[1] = 1;
        // initial recursive call: count == 2
        return fibonacciSequenceSpaceOfNRecursiveArray(num, 2, sequence)[num];
    }

    private int[] fibonacciSequenceSpaceOfNRecursiveArray(int num, int count, int[] result) {
        // Base case: return if count greater than num
        if (count > num) {
            return result;
        }
        // add last two values in list
        result[count] = result[count - 1] + result[count - 2];
        // recursive call: increment count
        return fibonacciSequenceSpaceOfNRecursiveArray(num, ++count, result);
    }

    public int fibonacciRecursiveSpaceOf1(int n) {
        // Base case: return if n less than 2
        if (n < 2) {
            return n;
        }
        // recursive call( n -1)  + recursive call( n -2)
        return fibonacciRecursiveSpaceOf1(n - 1) + fibonacciRecursiveSpaceOf1(n - 2);
    }

}
