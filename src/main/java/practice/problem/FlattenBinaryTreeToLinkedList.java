package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 114. Flatten Binary Tree to Linked List
// Microsoft ladder
public class FlattenBinaryTreeToLinkedList {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flattenIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
            if (!stack.isEmpty())
                curr.right = stack.peek();
            curr.left = null;
        }
    }
}
