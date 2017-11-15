/**
 * Created by Larry Liu on 11/14/2017.
 * 104. Maximum Depth of Binary Tree
 */
public class p104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
