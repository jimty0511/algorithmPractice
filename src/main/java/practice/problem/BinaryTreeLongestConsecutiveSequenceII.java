package practice.problem;

import practice.domain.TreeNode;

// 549. Binary Tree Longest Consecutive Sequence II
public class BinaryTreeLongestConsecutiveSequenceII {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }

    private int[] helper(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = helper(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inr = l[0] + 1;
        }
        if (root.right != null) {
            int[] r = helper(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inr = Math.max(inr, r[0] + 1);
        }
        max = Math.max(max, dcr + inr - 1);
        return new int[]{inr, dcr};
    }

    class ResultType {
        int maxLen, maxDown, maxUp;

        public ResultType(int maxLen, int maxDown, int maxUp) {
            this.maxLen = maxLen;
            this.maxDown = maxDown;
            this.maxUp = maxUp;
        }
    }

    public int longestConsecutiveTwo(TreeNode root) {
        return helperTwo(root).maxLen;
    }

    private ResultType helperTwo(TreeNode root) {
        if (root == null)
            return new ResultType(0, 0, 0);
        ResultType left = helperTwo(root.left);
        ResultType right = helperTwo(root.right);
        int down = 0, up = 0;
        if (root.left != null && root.left.val + 1 == root.val)
            down = Math.max(down, left.maxDown + 1);
        if (root.left != null && root.left.val - 1 == root.val)
            up = Math.max(up, left.maxUp + 1);
        if (root.right != null && root.right.val + 1 == root.val)
            down = Math.max(down, right.maxDown + 1);
        if (root.right != null && root.right.val - 1 == root.val)
            up = Math.max(up, right.maxUp + 1);
        int len = 1 + down + up;
        len = Math.max(len, Math.max(left.maxLen, right.maxLen));
        return new ResultType(len, down, up);
    }
}
