package practice.problem;

import practice.domain.TreeNode;

import java.util.*;

// 662. Maximum Width of Binary Tree
public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    private int dfs(TreeNode root, int level, int index, List<Integer> start, List<Integer> end) {
        if (root == null)
            return 0;
        if (start.size() == level) {
            start.add(index);
            end.add(index);
        } else {
            end.set(level, index);
        }
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, index * 2, start, end);
        int right = dfs(root.right, level + 1, index * 2 + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }

    public int widthOfBinaryTreeIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> m = new HashMap<>();
        queue.offer(root);
        m.put(root, 1);
        int curW = 0, maxW = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0)
                    start = m.get(node);
                if (i == size - 1)
                    end = m.get(node);
                if (node.left != null) {
                    m.put(node.left, m.get(node) * 2);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    m.put(node.right, m.get(node) * 2 + 1);
                    queue.offer(node.right);
                }
            }
            curW = end - start + 1;
            maxW = Math.max(curW, maxW);
        }
        return maxW;
    }

    public int widthOfBinaryTreeIterativeTwo(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        root.val = 0;
        int max = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            max = Math.max(max, q.peekLast().val - q.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                root = q.poll();
                if (root.left != null) {
                    root.left.val = root.val * 2;
                    q.offer(root.left);
                }
                if (root.right != null) {
                    root.right.val = root.val * 2 + 1;
                    q.offer(root.right);
                }
            }
        }
        return max;
    }
}
