package practice.problem;

import practice.domain.TreeNode;

public class MaximumBinaryTreeII {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root != null && root.val > val) {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        TreeNode node = new TreeNode(val);
        node.left = root;
        return node;
    }

    public TreeNode insertIntoMaxTreeIter(TreeNode root, int val) {
        TreeNode node = new TreeNode(val), cur = root;
        if (root.val < val) {
            node.left = root;
            return node;
        }
        while (cur.right != null && cur.right.val > val)
            cur = cur.right;
        node.left = cur.right;
        cur.right = node;
        return root;
    }
}
