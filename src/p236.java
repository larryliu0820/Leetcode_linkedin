/**
 * Created by mengwliu on 11/14/17.
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class p236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q) return q;
        if (root == p) return p;
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        if (leftRes == null && rightRes != null) return rightRes;
        if (leftRes != null && rightRes == null) return leftRes;
        if (leftRes != null && rightRes != null) return root;
        return null;
    }
}
