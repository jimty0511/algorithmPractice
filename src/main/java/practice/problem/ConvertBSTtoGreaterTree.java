package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 538. Convert BST to Greater Tree
public class ConvertBSTtoGreaterTree {
    int sum538 = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        root.val = root.val + sum538;
        sum538 = root.val;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBSTIterative(TreeNode root) {
        if (root == null)
            return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int tmp = cur.val;
            cur.val += sum;
            sum += tmp;
            cur = cur.left;
        }
        return root;
    }
}
