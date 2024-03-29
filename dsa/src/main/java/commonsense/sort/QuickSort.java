package commonsense.sort;

public class QuickSort {

    public QuickSort(int[] array) {
        this.array = array;
    }

    public static int[] sortedArray(int[] inputUnsortedInts) {
       return new QuickSort(inputUnsortedInts).sort(0,inputUnsortedInts.length - 1);
    }

    private int[] array;

    public int[] sort(int leftIdx, int rightIdx) {
        // base case - 1 cell array
        if ((rightIdx - leftIdx) <= 0) {
            return array;
        }
        // partition
        int partition = partition(leftIdx, rightIdx);

        // quicksort left
        sort(leftIdx, partition - 1);
        // quicksort right
        sort(partition + 1, rightIdx);


        return array;
    }

    // 3 2 1
    // 1 2 3
    public int partition(int leftIdx, int rightIdx) {
        // store partition value and idx
        int partitionIndex = rightIdx;
        int partitionValue = this.array[partitionIndex];

        // move right --
        rightIdx--;

        while (true) {
            // move left to swap value
            while (this.array[leftIdx] < partitionValue) {
                leftIdx++;
            }

            // move right to swap value
            while (rightIdx >= 0 && this.array[rightIdx] > partitionValue) {
                rightIdx--;
            }

            if (leftIdx >= rightIdx) {
                break;
            } else {
                // swap value
                int temp = this.array[rightIdx];
                this.array[rightIdx] = this.array[leftIdx];
                this.array[leftIdx] = temp;
            }
        }

        // swap left with partition value
        int temp = this.array[leftIdx];
        this.array[leftIdx] = this.array[partitionIndex];
        this.array[partitionIndex] = temp;

        return leftIdx;
    }
}
