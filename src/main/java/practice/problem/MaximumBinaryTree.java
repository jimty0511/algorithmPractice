package practice.problem;

import practice.domain.TreeNode;

// 654. Maximum Binary Tree
// Microsoft ladder
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(nums[start]);
        int idx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idx])
                idx = i;
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = build(nums, start, idx - 1);
        root.right = build(nums, idx + 1, end);
        return root;
    }

    public TreeNode constructMaximumBinaryTreeIterative(int[] nums) {
        if (nums.length == 0)
            return null;
        TreeNode head = new TreeNode(nums[0]);
        for (int k = 1; k < nums.length; k++) {
            int i = nums[k];
            TreeNode cur = head, pre = null;
            while (cur != null && i < cur.val) {
                pre = cur;
                cur = cur.right;
            }
            TreeNode newNode = new TreeNode(i);
            newNode.left = cur;
            if (pre == null) {
                head = newNode;
            } else {
                pre.right = newNode;
            }
        }
        return head;
    }
}
