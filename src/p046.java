import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 11/14/2017.
 * 46. Permutations
 */
public class p046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, new LinkedList<>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                backtrack(res, nums, path, visited);
                path.remove(path.size()-1);
                visited[i] = false;
            }
        }
    }
}
