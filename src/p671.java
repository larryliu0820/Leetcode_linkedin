/**
 * Created by Larry Liu on 11/16/2017.
 * 671. Second Minimum Node In a Binary Tree
 */
public class p671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.right == null && root.left == null) return -1;
        int leftRes = root.left.val;
        int rightRes = root.right.val;
        if (root.left.val == root.val) {
            leftRes = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            rightRes = findSecondMinimumValue(root.right);
        }

        if (leftRes != -1 && rightRes != -1) return Math.min(leftRes, rightRes);
        else if (leftRes != -1) return leftRes;
        else return rightRes;
    }
}
