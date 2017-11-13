import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengwliu on 11/11/17
 * 1. Two Sum
 */
public class p001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{i, map.get(target-nums[i])};
            }
            map.putIfAbsent(nums[i], i);
        }
        return null;
    }
}
