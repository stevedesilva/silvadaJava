package commonsense.recursion;

public class Factorial {
    public int calculateFactorial(int number) {
        return factorialRec(number, 1);
    }
    private int factorialRec(int number, int acc) {
        if (number <= 0) {
            return acc;
        }
        final int factor = number * acc;
        return factorialRec(number-1, factor);
    }
}
