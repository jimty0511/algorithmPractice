package practice.problem;

import practice.domain.TreeNode;

// 549. Binary Tree Longest Consecutive Sequence II
public class BinaryTreeLongestConsecutiveSequenceII {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }

    private int[] helper(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = helper(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inr = l[0] + 1;
        }
        if (root.right != null) {
            int[] r = helper(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inr = Math.max(inr, r[0] + 1);
        }
        max = Math.max(max, dcr + inr - 1);
        return new int[]{inr, dcr};
    }
}
