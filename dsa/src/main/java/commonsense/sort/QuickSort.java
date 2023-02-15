package commonsense.sort;

public class QuickSort {

    public QuickSort(int[] array) {
        this.array = array;
    }

    private int[] array;
    public int[] sort(int leftIdx, int rightIdx) {
        // base case
        if ((rightIdx - leftIdx) >= 0) {
            return array;
        }
        // partition
        int partition = partition(leftIdx,rightIdx);

        // quicksort left
        sort(leftIdx, partition -1);
        // quicksort right
        sort(partition + 1, rightIdx);


        return array;
    }


    private int partition(int leftIdx, int rightIdx) {
        return leftIdx;
    }
}
