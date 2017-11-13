import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 11/13/17
 * 366. Find Leaves of Binary Tree
 */
public class p366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, res);
        return res;
    }

    private int dfs(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        int leftDepth = dfs(node.left, res);
        int rightDepth = dfs(node.right, res);
        int currDepth = Math.max(leftDepth, rightDepth) + 1;
        if (res.size() <= currDepth) res.add(currDepth, new LinkedList<>());
        res.get(currDepth).add(node.val);
        return currDepth;
    }
}
