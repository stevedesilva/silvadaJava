package commonsense.optimise;

public class LargestSubsectionSum {

    public int largestSubsectionSum(int[] a) {
        // 1 - larger array needs to trade a larger number with a smaller number from the smaller array
        // 2 - with a single swap, each array sum changes by the same amount  (e.g. given 7,4 increases by 3, decreases by 3)
        // 3 - swaps cause the 2 array sums to fall out exactly in the middle of where the two arrays sums began (e.g. 18, 12 -> 15)
        // Therefore if we know the sums of the 2 arrays, we should be able to look at any number in one of the arrays and calculate what number it should be swapped with in the other array

        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < a.length; i++) {
            currentSum = Math.max(a[i], currentSum + a[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
