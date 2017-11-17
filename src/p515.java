import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Larry Liu on 11/16/2017.
 * 515. Find Largest Value in Each Tree Row
 */
public class p515 {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null) level.offer(curr.left);
                if (curr.right != null) level.offer(curr.right);
            }
            res.add(max);
            queue = level;
        }
        return res;
    }
}
