package commonsense.optimise;

public class MaxProduct {


    public int findMaxProductInArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException("input array cannot be less than 1 element");
        }

        int maxValue1 = -Integer.MAX_VALUE;
        int maxValue2= -Integer.MAX_VALUE;
        int leastValue1 = Integer.MAX_VALUE;
        int leastValue2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // find the two largest values
            if (nums[i] > maxValue1) {
                maxValue2 = maxValue1;
                maxValue1 = nums[i];
            } else if (nums[i] > maxValue2) {
                maxValue2 = nums[i];
            }
            // find the two smallest values
            if (nums[i] < leastValue1) {
                leastValue2 = leastValue1;
                leastValue1 = nums[i];
            } else if (nums[i] < leastValue2) {
                leastValue2 = nums[i];
            }
        }

        final int max = maxValue1 * maxValue2;
        final int least = leastValue1 * leastValue2;
        return Math.max(max, least);

    }
}
