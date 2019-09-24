package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 897. Increasing Order Search Tree
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        return helper(root, null);
    }

    private TreeNode helper(TreeNode root, TreeNode tail) {
        if (root == null)
            return tail;
        TreeNode res = helper(root.left, root);
        root.left = null;
        root.right = helper(root.right, tail);
        return res;
    }

    public TreeNode increasingBSTIter(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(0);
        TreeNode cur = dummy;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            cur.right = root;
            cur = cur.right;
            root.left = null;
            root = root.right;
        }
        return dummy.right;
    }

}
