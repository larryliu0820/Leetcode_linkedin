/**
 * Created by Larry Liu on 11/15/2017.
 * 198. House Robber
 */
public class p198 {
    public int rob(int[] nums) {
        int dp0 = 0, dp1 = 0;
        for (int num: nums) {
            int temp = dp1;
            dp1 = Math.max(dp0 + num, dp1);
            dp0 = Math.max(temp, dp0);
        }
        return Math.max(dp0, dp1);
    }
}
