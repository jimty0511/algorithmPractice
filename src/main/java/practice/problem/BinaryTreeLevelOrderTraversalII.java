package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 107. Binary Tree Level Order Traversal II
// Microsoft ladder
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(0, subList);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottomDfs(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelOrderBottomDfsHelper(result, root, 0);
        return result;
    }

    private void levelOrderBottomDfsHelper(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;
        if (level >= result.size()) {
            result.add(0, new LinkedList<>());
        }
        levelOrderBottomDfsHelper(result, root.left, level + 1);
        levelOrderBottomDfsHelper(result, root.right, level + 1);
        result.get(result.size() - level - 1).add(root.val);
    }
}
