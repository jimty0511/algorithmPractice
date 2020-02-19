package practice.problem;

import practice.domain.TreeNode;

// 1145. Binary Tree Coloring Game
public class BinaryTreeColoringGame {

    int left, right, val;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.val = x;
        countNodes(root);
        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    private int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        if (root.val == val) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }
}
