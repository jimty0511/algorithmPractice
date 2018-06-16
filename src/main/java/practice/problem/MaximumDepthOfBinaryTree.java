package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 104. Maximum Depth of Binary Tree
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepthBfs(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            level++;
        }
        return level;
    }

    public int maxDepthDfs(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        treeNodeStack.push(root);
        valueStack.push(1);
        int max = 0;
        while (!treeNodeStack.isEmpty()) {
            TreeNode node = treeNodeStack.pop();
            int temp = valueStack.pop();
            max = Math.max(temp, max);
            if (node.left != null) {
                treeNodeStack.push(node.left);
                valueStack.push(temp + 1);
            }
            if (node.right != null) {
                treeNodeStack.push(node.right);
                valueStack.push(temp + 1);
            }
        }
        return max;
    }
}
