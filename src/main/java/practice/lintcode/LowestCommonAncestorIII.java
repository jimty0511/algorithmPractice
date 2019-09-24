package practice.lintcode;

import practice.domain.TreeNode;

// 578. Lowest Common Ancestor III
public class LowestCommonAncestorIII {
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        TreeNode res = helper(root, A, B);
        if (foundA && foundB)
            return res;
        else
            return null;
    }

    boolean foundA = false, foundB = false;

    private TreeNode helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null)
            return null;
        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);
        if (root == A || root == B) {
            foundA = root == A || foundA;
            foundB = root == B || foundB;
            return root;
        }
        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else if (right != null)
            return right;
        else
            return null;
    }
}
