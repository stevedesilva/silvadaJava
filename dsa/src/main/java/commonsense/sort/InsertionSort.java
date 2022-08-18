package commonsense.sort;

import java.time.chrono.MinguoDate;

/*
  For every element in the array:
    for current element
    sort everything to the left of the element
*/
public class InsertionSort {
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int position = i;
            int currValue = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > currValue) {
                    array[position] = array[j];
                    position = j;
                } else {
                    break;
                }
            }
            if (i != position) {
                array[position] = currValue;
            }
        }
        return array;
    }

    public int[] sortOfficial(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int position = i - 1;
            while (position >= 0) {
                if (array[position] > value) {
                    array[position + 1] = array[position];
                    position--;
                } else {
                    break;
                }
            }
            array[position + 1] = value;
        }
        return array;
    }
}


