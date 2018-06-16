package practice.problem;

import practice.domain.TreeNode;

// 110. Balanced Binary Tree
public class BalanceBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalancedDepth(root) != -1;
    }

    private int isBalancedDepth(TreeNode root) {
        if (root == null) return 0;
        int l = isBalancedDepth(root.left);
        int r = isBalancedDepth(root.right);
        if (l == -1 || r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }
}
