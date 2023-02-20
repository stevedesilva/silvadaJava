package commonsense.sort;

public class QuickSelect {

    public QuickSelect(int[] array) {
        this.array = array;
    }

    private int[] array;

    public int select(int indexToFind, int leftIdx, int rightIdx) {
        // base case - 1 cell array
        if ((rightIdx - leftIdx) <= 0) {
            return array[leftIdx];
        }
        // partition
        int partition = partition(leftIdx, rightIdx);

        if (indexToFind < partition) {
            // quicksort left
            return select(indexToFind,leftIdx, partition - 1);
        } else if (indexToFind > partition) {
            // quicksort right
           return select(indexToFind,partition + 1, rightIdx);
        } else {
            return array[partition];
        }
    }

    // 3 2 1
    // 1 2 3
    public int partition(int leftIdx, int rightIdx) {
        // store partition value and idx
        int partitionIdx = rightIdx;
        int partitionValue = this.array[partitionIdx];

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
        this.array[leftIdx] = this.array[partitionIdx];
        this.array[partitionIdx] = temp;

        return leftIdx;
    }
}
