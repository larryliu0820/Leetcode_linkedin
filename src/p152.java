/**
 * Created by mengwliu on 11/14/17.
 * 152. Maximum Product Subarray
 */
public class p152 {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMin = Math.min(nums[i], currMin * nums[i]);
            currMax = Math.max(nums[i], currMax * nums[i]);

            maxProduct = Math.max(maxProduct, currMax);
        }
        return maxProduct;
    }
}
