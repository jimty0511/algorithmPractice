package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

// 112. Path Sum
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum - root.val == 0) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<Integer> remain = new Stack<>();
        treeNodeStack.push(root);
        remain.push(sum);
        while (!treeNodeStack.isEmpty() && !remain.isEmpty()) {
            TreeNode cur = treeNodeStack.pop();
            int rem = remain.pop();
            if (rem == cur.val && cur.left == null && cur.right == null)
                return true;
            if (cur.left != null) {
                treeNodeStack.push(cur.left);
                remain.push(rem - cur.val);
            }
            if (cur.right != null) {
                treeNodeStack.push(cur.right);
                remain.push(rem - cur.val);
            }
        }
        return false;
    }
}
