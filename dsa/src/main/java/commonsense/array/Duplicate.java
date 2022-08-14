package commonsense.array;

public class Duplicate {
    public boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i]==array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
