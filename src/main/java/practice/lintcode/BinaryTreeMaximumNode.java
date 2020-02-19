package practice.lintcode;

import practice.domain.TreeNode;

// 632. Binary Tree Maximum Node
// Airbnb ladder
public class BinaryTreeMaximumNode {

    private TreeNode res;
    private int max = Integer.MIN_VALUE;

    /*
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {
        // write your code here
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        if (root.val > max) {
            max = root.val;
            res = root;
        }
        helper(root.left);
        helper(root.right);
    }
}
