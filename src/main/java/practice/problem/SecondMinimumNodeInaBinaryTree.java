package practice.problem;

import practice.domain.TreeNode;

// 671. Second Minimum Node In a Binary Tree
public class SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return -1;
        int left = root.left.val;
        int right = root.right.val;
        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }
}
