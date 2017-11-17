import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by Larry Liu on 11/15/2017.
 * 173. Binary Search Tree Iterator
 */
public class p173 {
    Stack<TreeNode> stack;
    public p173(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        int res = top.val;
        pushLeft(top.right);
        return res;
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
