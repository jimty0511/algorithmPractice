package practice.problem;

import practice.domain.TreeNode;

// 222. Count Complete Tree Nodes
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int nodes = 0;
        int h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodesTwo(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = countNodesTwo(root.left);
        int right = countNodesTwo(root.right);
        return 1 + left + right;
    }
}
