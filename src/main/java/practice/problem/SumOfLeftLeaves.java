package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 404. Sum of Left Leaves
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null && curr.left.left == null && curr.left.right == null)
                res += curr.left.val;
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }
        return res;
    }
}
