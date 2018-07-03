package practice.problem;

import practice.domain.TreeNode;

// 99. Recover Binary Search Tree
public class RecoveryBinarySearchTree {

    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
