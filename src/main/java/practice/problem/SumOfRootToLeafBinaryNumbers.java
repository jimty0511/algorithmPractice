package practice.problem;

import practice.domain.TreeNode;

// 1022. Sum of Root To Leaf Binary Numbers
public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null)
            return 0;
        val = val * 2 + root.val;
        // root.left == null && root.right == null
        return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val);
    }


    private int ans = 0;

    public int sumRootToLeafTwo(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int val) {
        if (root == null)
            return;
        val = val << 1 | root.val;
        if (root.left == null && root.right == null)
            ans += val;
        helper(root.left, val);
        helper(root.right, val);
    }
}
