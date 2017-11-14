import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Larry Liu on 11/13/2017.
 * 297. Serialize and Deserialize Binary Tree
 */
public class p297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                q.offer(curr.left);
                sb.append(',').append(curr.left.val);
            } else sb.append(",#");

            if (curr.right != null) {
                q.offer(curr.right);
                sb.append(',').append(curr.right.val);
            } else sb.append(",#");
        }
        while (sb.charAt(sb.length()-1) == '#') sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;
        String[] arr = data.split(",");
        int ind = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[ind]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (ind < arr.length && !arr[ind].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(arr[ind]));
                q.offer(curr.left);
            }
            ind++;
            if (ind < arr.length && !arr[ind].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(arr[ind]));
                q.offer(curr.right);
            }
            ind++;
        }
        return root;
    }
}
