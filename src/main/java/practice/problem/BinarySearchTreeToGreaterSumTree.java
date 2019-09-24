package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 1038. Binary Search Tree to Greater Sum Tree
public class BinarySearchTreeToGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }

    int pre = 0;

    public TreeNode bstToGstTwo(TreeNode root) {
        if (root.right != null)
            bstToGstTwo(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null)
            bstToGstTwo(root.left);
        return root;
    }
}
