package practice.problem;

import practice.domain.TreeNode;

public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val > R)
            return trimBST(root.left, L, R);
        if (root.val < L)
            return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public TreeNode trimBSTIter(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        while (root != null && (root.val < L || root.val > R)) {
            if (root.val < L)
                root = root.right;
            if (root.val > R)
                root = root.left;
        }
        TreeNode cur = root;
        while (cur != null) {
            while (cur.left != null && cur.left.val < L)
                cur.left = cur.left.right;
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            while (cur.right != null && cur.right.val > R)
                cur.right = cur.right.left;
            cur = cur.right;
        }
        return root;
    }
}
