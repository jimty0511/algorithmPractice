package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;
import java.util.TreeSet;

// 530. Minimum Absolute Difference in BST
public class MinimumAbsoluteDifferenceInBST {

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return min;
        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }

    TreeSet<Integer> set = new TreeSet<>();

    public int getMinimumDifferenceTreeSet(TreeNode root) {
        if (root == null)
            return min;
        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, set.ceiling(root.val) - root.val);
            }
        }
        set.add(root.val);
        getMinimumDifferenceTreeSet(root.left);
        getMinimumDifferenceTreeSet(root.right);
        return min;
    }

    public int getMinimumDifferenceThree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null)
                min = Math.min(min, root.val - prev.val);
            prev = root;
            root = root.right;
        }
        return min;
    }
}
