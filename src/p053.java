
/**
 * Created by mengwliu on 11/13/17.
 * 53. Maximum Subarray
 */
public class p053 {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum = currSum > 0? currSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
