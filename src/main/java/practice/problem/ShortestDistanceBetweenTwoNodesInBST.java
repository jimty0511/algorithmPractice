package practice.problem;

import practice.domain.TreeNode;

public class ShortestDistanceBetweenTwoNodesInBST {

    public TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val > val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }

    public int distance(TreeNode treeNode, int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return helper(treeNode, a, b);
    }

    private int helper(TreeNode root, int a, int b) {
        if (root == null)
            return 0;
        if (root.val > a && root.val > b)
            return helper(root.left, a, b);
        if (root.val < a && root.val < b)
            return helper(root.right, a, b);
        if (root.val > a && root.val <= b)
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);
        return -1;
    }

    private int distanceFromRoot(TreeNode root, int val) {
        if (root.val == val)
            return 0;
        else if (root.val > val)
            return 1 + distanceFromRoot(root.left, val);
        return 1 + distanceFromRoot(root.right, val);
    }
}
