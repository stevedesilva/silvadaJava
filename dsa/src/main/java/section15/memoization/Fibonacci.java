package section15.memoization;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Fibonacci {

    static public Map<Integer, Long> cache = new ConcurrentHashMap<>();

    public static long fibonacciWithMemoization(int number)  {
            if (number < 2) {
                return number;
            }
            return cache.computeIfAbsent(number, (n) -> {
                System.out.println("Not Found in Cache, Calculate Fibonacci(" + n + ")");
                return fibonacciWithMemoization(n - 1) + fibonacciWithMemoization(n - 2);
            });
    };

}
