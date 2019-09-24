package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 971. Flip Binary Tree To Match Preorder Traversal
public class FlipBinaryTreeToMatchPreorderTraversal {
    List<Integer> res = new ArrayList<>();
    int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return helper(root, voyage) ? res : Arrays.asList(-1);
    }

    private boolean helper(TreeNode node, int[] v) {
        if (node == null)
            return true;
        if (node.val != v[i++])
            return false;
        if (node.left != null && node.left.val != v[i]) {
            res.add(node.val);
            return helper(node.right, v) && helper(node.left, v);
        }
        return helper(node.left, v) && helper(node.right, v);
    }

    public List<Integer> flipMatchVoyageIter(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int i = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;
            if (node.val != voyage[i++])
                return Arrays.asList(-1);
            if (node.right != null && node.right.val == voyage[i]) {
                if (node.left != null)
                    res.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            } else {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;
    }
}
