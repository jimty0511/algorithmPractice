package practice.problem;

import practice.domain.TreeNode;

// 687. Longest Univalue Path
public class LongestUnivaluePath {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            helper(root);
        }
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sumLeft = 0, sumRight = 0;
        if (root.left != null && root.left.val == root.val) {
            sumLeft = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            sumRight = right + 1;
        }
        max = Math.max(max, sumLeft + sumRight);
        return Math.max(sumLeft, sumRight);
    }
}
