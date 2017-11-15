import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mengwliu on 11/14/17.
 * 102. Binary Tree Level Order Traversal
 */
public class p102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            List<Integer> level = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    temp.offer(curr.left);
                }
                if (curr.right != null) {
                    temp.offer(curr.right);
                }
            }
            q = temp;
            res.add(level);
        }
        return res;
    }
}
