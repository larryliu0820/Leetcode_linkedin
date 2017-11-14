import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 11/13/17
 * 254. Factor Combinations
 */
public class p254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, new LinkedList<>(), n, 2);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int n, int start) {
        if (n == 1) {
            if (path.size() > 1) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                path.add(i);
                backtrack(res, path, n / i, i);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        p254 sol = new p254();
        sol.getFactors(32);
    }
}
