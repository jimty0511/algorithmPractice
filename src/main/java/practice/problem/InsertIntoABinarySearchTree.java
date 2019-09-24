package practice.problem;

import practice.domain.TreeNode;

// 701. Insert into a Binary Search Tree
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBSTIter(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode curr = root;
        while (true) {
            if (curr.val <= val) {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    public TreeNode insertIntoBSTRecursive(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val > val)
            root.left = insertIntoBSTRecursive(root.left, val);
        else
            root.right = insertIntoBSTRecursive(root.right, val);
        return root;
    }
}
