package practice.problem;

import practice.domain.TreeNode;

// 938. Range Sum of BST
public class RangeSumOfBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return sum;
    }

    private void helper(TreeNode root, int L, int R) {
        if (root == null)
            return;
        if (root.val <= R && root.val >= L) {
            sum += root.val;
            helper(root.left, L, R);
            helper(root.right, L, R);
        } else if (root.val < L) {
            helper(root.right, L, R);
        } else {
            helper(root.left, L, R);
        }
    }
}
