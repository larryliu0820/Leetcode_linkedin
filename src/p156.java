
/**
 * Created by mengwliu on 11/12/17
 * 156. Binary Tree Upside Down
 */
public class p156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) return root;
        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left = null;
        root.right = null;
        oldLeft.left = oldRight;
        oldLeft.right = root;
        return newRoot;
    }
}
