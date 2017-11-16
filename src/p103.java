import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 11/15/17.
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class p103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        boolean leftToRight = true;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<TreeNode> next = new LinkedList<>();
            List<Integer> level = new LinkedList<>();
            int index = 0;
            while (index < list.size()) {
                TreeNode curr = list.get(index);
                level.add(curr.val);
                if (leftToRight) {
                    if (curr.left != null) next.add(0, curr.left);
                    if (curr.right != null) next.add(0, curr.right);
                } else {
                    if (curr.right != null) next.add(0, curr.right);
                    if (curr.left != null) next.add(0, curr.left);
                }
                index++;
            }
            leftToRight = !leftToRight;
            res.add(level);
            list = next;
        }
        return res;
    }
}
