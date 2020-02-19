package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 1161. Maximum Level Sum of a Binary Tree
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        int max = Integer.MIN_VALUE;
        int res = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            if (max < sum) {
                max = sum;
                res = level;
            }
            level++;
        }
        return res;
    }
}
