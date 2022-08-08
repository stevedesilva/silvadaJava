package commonsense.sort;

public class BubbleSort {
    public int[] sort(int[] array) {
        int end = array.length;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < end; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    sorted = false;
                }
            }
            end--;
        }
        return array;
    }
}
