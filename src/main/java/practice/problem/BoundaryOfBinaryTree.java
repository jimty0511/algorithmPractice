package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 545. Boundary of Binary Tree
public class BoundaryOfBinaryTree {
    List<Integer> boundaryOfBinaryTreeResult = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)
            return boundaryOfBinaryTreeResult;
        boundaryOfBinaryTreeResult.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return boundaryOfBinaryTreeResult;
    }

    private void leftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        boundaryOfBinaryTreeResult.add(root.val);
        if (root.left == null)
            leftBoundary(root.right);
        else
            leftBoundary(root.left);
    }

    private void rightBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        if (root.right == null)
            rightBoundary(root.left);
        else
            rightBoundary(root.right);
        boundaryOfBinaryTreeResult.add(root.val);
    }

    private void leaves(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            boundaryOfBinaryTreeResult.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}
