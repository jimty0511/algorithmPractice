package practice.lintcode;

import practice.domain.TreeNode;

// 596. Minimum Subtree
public class MinimumSubtree {

    TreeNode res = null;
    int subtreeSum = Integer.MAX_VALUE;

    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int sum = helper(root.left) + helper(root.right) + root.val;
        if (sum < subtreeSum) {
            subtreeSum = sum;
            res = root;
        }
        return sum;
    }
}
