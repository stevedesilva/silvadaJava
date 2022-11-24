package commonsense.recursion;

public class DoubleNumbers {
    public static int[] doubleNumbers(int[] numbers) {
        return doubleNumbersRec(numbers, 0);
    }

    private static int[] doubleNumbersRec(int[] numbers, int counter) {
        if(counter >= numbers.length) {
            return numbers;
        }
        numbers[counter] *= 2;
        return doubleNumbersRec(numbers, counter + 1);
    }
}
