package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 102. Binary Tree Level Order Traversal
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                subList.add(curr.val);
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            result.add(subList);
        }
        return result;
    }

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        levelOrderDfsHelper(result, root, 0);
        return result;
    }

    private void levelOrderDfsHelper(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;
        List<Integer> curr;
        if (level >= result.size()) {
            curr = new LinkedList<>();
            curr.add(root.val);
            result.add(curr);
        } else {
            curr = result.get(level);
            curr.add(root.val);
        }
        levelOrderDfsHelper(result, root.left, level + 1);
        levelOrderDfsHelper(result, root.right, level + 1);
    }
}
