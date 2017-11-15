/**
 * Created by Larry Liu on 11/14/2017.
 * 238. Product of Array Except Self
 */
public class p238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i-1] * res[i-1];
        }

        int product = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }
}
