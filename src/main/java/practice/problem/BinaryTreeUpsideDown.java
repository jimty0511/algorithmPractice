package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 156. Binary Tree Upside Down
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null)
            return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public TreeNode upsideDownBinaryTreeIterative(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;
        while (curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public TreeNode upsideDownBinaryTreeIterativeStk(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stk = new Stack<>();
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
        root = stk.peek();
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            node.left = null;
            node.right = null;
            if (stk.isEmpty())
                break;
            TreeNode upNode = stk.peek();
            node.right = upNode;
            if (upNode.right != null)
                node.left = upNode.right;
        }
        return root;
    }
}
