/**
 * Created by mengwliu on 11/14/17.
 * 34. Search for a Range
 */
public class p034 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        for (int i = 0; i < 2; i++) {
            if (res[i] < 0 || res[i] >= nums.length || nums[res[i]] != target) res[i] = -1;
        }
        return res;
    }

    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int lo = 0, hi = nums.length-1, mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] < target) lo = mid+1;
            else if (nums[mid] > target) hi = mid-1;
            else {
                if (isLeft) {
                    if (mid == 0 || nums[mid-1] != target) return mid;
                    else hi = mid-1;
                } else {
                    if (mid == nums.length-1 || nums[mid+1] != target) return mid;
                    else lo = mid+1;
                }
            }
        }
        return lo;
    }
}
