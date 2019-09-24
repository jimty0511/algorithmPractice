package practice.lintcode;

import practice.domain.TreeNode;

// 597. Subtree with Maximum Average (LintCode)
public class SubtreeWithMaximumAverage {

    private int[] max = null;
    private TreeNode res = null;

    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] cur = new int[]{left[0] + right[0] + root.val, left[1] + right[1] + 1};
        if (max == null || max[0] * cur[1] < cur[0] * max[1]) {
            res = root;
            max = cur;
        }
        return cur;
    }
}
