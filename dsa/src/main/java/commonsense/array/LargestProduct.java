package commonsense.array;

public class LargestProduct {
    public static final String MINIMUM_OF_3_VALUES_REQUIRED = "minimum of 3 values required";

    public static int findLargestProduct(int[] array) throws IllegalArgumentException {
        if (array == null || array.length < 3) {
            throw new IllegalArgumentException(MINIMUM_OF_3_VALUES_REQUIRED);
        }
        int largestProduct = 0;
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                for(int k = j + 1; k < array.length; k++) {
                    final int product = array[i] * array[j] * array[k];
                    if(largestProduct < product) {
                        largestProduct = product;
                    }
                }
            }
        }
        return largestProduct;
    }
}
