package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 298. Binary Tree Longest Consecutive Sequence
public class BinaryTreeLongestConsecutiveSequence {
    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, 0, root.val);
        return max;
    }

    private void helper(TreeNode root, int cur, int target) {
        if (root == null)
            return;
        if (root.val == target)
            cur++;
        else
            cur = 1;
        max = Math.max(cur, max);
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }

    public int longestConsecutiveIterative(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> integerQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        integerQueue.offer(1);
        int max = 1;
        while (!treeNodeQueue.isEmpty()) {
            TreeNode cur = treeNodeQueue.poll();
            int count = integerQueue.poll();
            if (cur.left != null) {
                treeNodeQueue.offer(cur.left);
                if (cur.left.val == cur.val + 1) {
                    integerQueue.offer(count + 1);
                    max = Math.max(max, count + 1);
                } else {
                    integerQueue.offer(1);
                }
            }
            if (cur.right != null) {
                treeNodeQueue.offer(cur.right);
                if (cur.right.val == cur.val + 1) {
                    integerQueue.offer(count + 1);
                    max = Math.max(max, count + 1);
                } else {
                    integerQueue.offer(1);
                }
            }
        }
        return max;
    }
}
