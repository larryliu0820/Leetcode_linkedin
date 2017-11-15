import java.util.Set;

/**
 * Created by Larry Liu on 11/13/2017.
 * 698. Partition to K Equal Sum Subsets
 */
public class p698 {
    int[] nums;
    boolean[] visited;
    int target;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int sum = 0;
        for (int num: nums) sum += num;
        if (k <= 0 || sum % k != 0) return false;
        target = sum / k;
        visited = new boolean[nums.length];
        return backtrack(k, 0, 0);
    }

    private boolean backtrack(int k, int start, int sum) {
        if (k == 1) return true;
        if (sum == target) return backtrack(k-1, 0, 0);
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (backtrack(k, i+1, sum+nums[i])) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
