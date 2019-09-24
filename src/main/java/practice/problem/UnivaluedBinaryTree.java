package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree {
    public boolean isUnivalTreeIterative(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n.val != root.val)
                return false;
            if (n.left != null)
                queue.offer(n.left);
            if (n.right != null)
                queue.offer(n.right);
        }
        return true;
    }

    public boolean isUnivalTreeRecursive(TreeNode root) {
        return (root.left == null || root.left.val == root.val && isUnivalTreeRecursive(root.left)) &&
                (root.right == null || root.right.val == root.val && isUnivalTreeRecursive(root.right));
    }
}
