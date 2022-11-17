package commonsense.recursion;

public class Sum {
    public int sumNumberBetweenRangeNonTailRecursion(int low, int high) {
        if (low >= high) {
            return high;
        }
        return low + sumNumberBetweenRangeNonTailRecursion(low + 1, high);
    }

    public int sumNumberBetweenRangeWithTailRecursion(int low, int high) {
        return sumNumberBetweenRangeNonTailRecursion(low, high);
    }

    private int sumNumberBetweenRangeWithTailRecursionRec(int low, int high, int acc) {
        if (low > high) {
            return acc;
        }
        acc = low + acc;
        return sumNumberBetweenRangeWithTailRecursionRec(low + 1, high, acc);
    }
}
