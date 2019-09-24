package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

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

    public int minDiffInBSTStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int diff = Integer.MAX_VALUE;
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null)
                diff = Math.min(diff, root.val - prev.val);
            prev = root;
            root = root.right;
        }
        return diff;
    }
}
