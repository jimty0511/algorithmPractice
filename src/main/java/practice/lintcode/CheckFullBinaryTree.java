package practice.lintcode;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 726. Check Full Binary Tree (LC)
public class CheckFullBinaryTree {
    public boolean isFullTree(TreeNode root) {
        // write your code here
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left != null && root.right != null)
            return isFullTree(root.left) && isFullTree(root.right);
        return false;
    }

    public boolean isFullTreeBfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left == null && node.right == null)
                continue;
            if (node.left == null || node.right == null)
                return false;
            q.offer(node.left);
            q.offer(node.right);
        }
        return true;
    }
}
