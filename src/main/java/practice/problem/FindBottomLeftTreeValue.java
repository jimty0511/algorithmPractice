package practice.problem;

import practice.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 513. Find Bottom Left Tree Value
public class FindBottomLeftTreeValue {
    public int findBottomLeftValueBfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0)
                    result = node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return result;
    }

    public int findBottomLeftValueBfsTwo(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.offer(root.right);
            if (root.left != null)
                queue.offer(root.left);
        }
        return root.val;
    }

    int bottomLeftValue = 0, bottomLeftLevel = 0;

    public int findBottomLeftValueDfs(TreeNode root) {
        findBottomLeftValueDfsHelper(root, 1);
        return bottomLeftValue;
    }

    private void findBottomLeftValueDfsHelper(TreeNode root, int curLevel) {
        if (curLevel > bottomLeftLevel) {
            bottomLeftValue = root.val;
            bottomLeftLevel++;
        }
        if (root.left != null)
            findBottomLeftValueDfsHelper(root.left, curLevel + 1);
        if (root.right != null)
            findBottomLeftValueDfsHelper(root.right, curLevel + 1);
    }
}
