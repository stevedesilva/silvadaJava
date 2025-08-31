package commonsense.optimise;

public class MaxProduct {


    public int findMaxProductInArray(int[] nums) {
        int maxProduct = 0;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // if current sum + number is less that 0 then reset current sum to 0
            currentSum = Math.max(currentSum + nums[i], 0);
            // if current sum is greater than max sum then set max sum to current sum
            maxProduct = Math.max(maxProduct, currentSum);
        }
        return maxProduct;
    }
}
