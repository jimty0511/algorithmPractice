package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 515. Find Largest Value in Each Tree Row
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValuesBfs(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(max);
        }
        return result;
    }

    public List<Integer> largestValuesDfs(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        largestValuesDfsHelper(root, result, 0);
        return result;
    }

    private void largestValuesDfsHelper(TreeNode root, List<Integer> result, int level) {
        if (root == null)
            return;
        if (level == result.size())
            result.add(root.val);
        else
            result.set(level, Math.max(root.val, result.get(level)));
        largestValuesDfsHelper(root.left, result, level + 1);
        largestValuesDfsHelper(root.right, result, level + 1);
    }
}
