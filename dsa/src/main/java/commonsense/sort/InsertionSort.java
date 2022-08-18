package commonsense.sort;
/*
  For every element in the array:
    for current element
    sort everything to the left of the element
*/
public class InsertionSort {
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int idxToInsertValue = i;
            int currValue = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if(array[j] > currValue) {
                    array[idxToInsertValue] = array[j];
                    idxToInsertValue = j;
                } else {
                    break;
                }
            }
            if (i != idxToInsertValue) {
                array[idxToInsertValue] = currValue;
            }
        }
        return array;
    }
}
