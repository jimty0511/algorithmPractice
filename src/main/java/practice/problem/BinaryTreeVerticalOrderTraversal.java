package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 314. Binary Tree Vertical Order Traversal
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        int[] range = new int[2];
        getRange(root, range, 0);
        for (int i = range[0]; i <= range[1]; i++) {
            result.add(new ArrayList<>());
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        colQueue.offer(-range[0]);
        while (!treeNodeQueue.isEmpty()) {
            TreeNode curr = treeNodeQueue.poll();
            int col = colQueue.poll();
            result.get(col).add(curr.val);
            if (curr.left != null) {
                treeNodeQueue.offer(curr.left);
                colQueue.offer(col - 1);
            }
            if (curr.right != null) {
                treeNodeQueue.offer(curr.right);
                colQueue.offer(col + 1);
            }
        }
        return result;
    }

    private void getRange(TreeNode root, int[] range, int col) {
        if (root == null)
            return;
        range[0] = Math.min(range[0], col);
        range[1] = Math.max(range[1], col);
        getRange(root.left, range, col - 1);
        getRange(root.right, range, col + 1);
    }
}
