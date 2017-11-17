import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/15/2017.
 * 47. Permutations II
 */
public class p047 {
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.res = new LinkedList<>();
        Arrays.sort(this.nums);
        backtrack(new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            path.add(nums[i]);
            backtrack(path, visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}
