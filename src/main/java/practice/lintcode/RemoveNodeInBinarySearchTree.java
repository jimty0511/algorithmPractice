package practice.lintcode;

import practice.domain.TreeNode;

// 87. Remove Node in Binary Search Tree
public class RemoveNodeInBinarySearchTree {
    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        return remove(root, value);
    }

    private TreeNode remove(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                int max = findMax(root.left);
                root.val = max;
                root.left = removeNode(root.left, max);
            }
        } else if (root.val > val)
            root.left = remove(root.left, val);
        else
            root.right = removeNode(root.right, val);
        return root;
    }

    private int findMax(TreeNode root) {
        if (root.right == null)
            return root.val;
        return findMax(root.right);
    }
}
