package practice.problem;

import practice.domain.TreeNode;

// 783. Minimum Distance Between BST Nodes
public class MinimumDistanceBetweenBSTNodes {
    Integer res = Integer.MAX_VALUE, pre = null;

    public int minDiffInBST(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        helper(root.right);
    }
}
