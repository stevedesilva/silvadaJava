package commonsense.recursion.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static int fibonacci(int number) {
        return fibonacciRec(number,new HashMap<Integer, Integer>());
    }

    public static int fibonacciRec(int number, Map<Integer, Integer> cache) {
        System.out.println(number);
        if (number <= 1) {
            return number;
        }
        int value;
        if (!cache.containsKey(number)) {
            value = fibonacciRec(number - 1, cache) + fibonacciRec(number - 2, cache);
            cache.put(number, value);
            return value;
        } else {
            System.out.println("cached: "+number);
            return cache.get(number);
        }
    }

    public static int fibonacciNoAdditionalSpace(int number) {
        int a = 0;
        int b = 1;
        if(number <= 0) return number;
        for (int i = 1; i < number; i++) {
            int temp = a;
            a = b;
            b = temp + a;
        }
        return b;
    }
}
