package practice.problem;

import practice.domain.TreeNode;

// 124. Binary Tree Maximum Path Sum
public class BinaryTreeMaximumPathSum {
    int res;

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
