package practice.problem;

import practice.domain.TreeNode;

// 235. Lowest Common Ancestor of a Binary Search Tree
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        TreeNode low = p.val > q.val ? q : p;
        TreeNode high = p.val < q.val ? q : p;
        TreeNode node = root;
        while (!(node.val >= low.val && node.val <= high.val)) {
            while (node.val > high.val) {
                node = node.left;
            }
            while (node.val < low.val) {
                node = node.right;
            }
        }
        return node;
    }
}
