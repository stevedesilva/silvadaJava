package commonsense.array;

public class MeanNumbers {
    public static float getMeanFromEvenNumbers(int[] array) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0) {
                count++;
                sum += array[i];
            }
        }

        if (count < 1) {
            throw new IllegalArgumentException("No even numbers found");
        }
        return sum/count;
    }
}
