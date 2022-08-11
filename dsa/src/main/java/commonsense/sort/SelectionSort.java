package commonsense.sort;

public class SelectionSort {
    public int[] sort(int[] array) {
        for(int i=0; i < array.length; i++) {
            int lowest = i;
            for(int j=i+1; j < array.length; j++) {
                if (array[j] < array[lowest]) {
                    lowest = j;
                }
            }
            if (lowest != i) {
                int temp = array[i];
                array[i] = array[lowest];
                array[lowest] = temp;
            }
        }
        return array;
    }
}
