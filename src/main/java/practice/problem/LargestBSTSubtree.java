package practice.problem;

import practice.domain.TreeNode;

// 333. Largest BST Subtree
// Microsoft ladder
public class LargestBSTSubtree {
    class SubTree {
        int size;
        int lower;
        int upper;

        SubTree(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;
        traverse(root);
        return max;
    }

    private SubTree traverse(TreeNode root) {
        if (root == null)
            return new SubTree(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        SubTree left = traverse(root.left);
        SubTree right = traverse(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new SubTree(-1, 0, 0);
        }
        int size = left.size + right.size + 1;
        max = Math.max(size, max);
        return new SubTree(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}
