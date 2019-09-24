package practice.problem;

import practice.domain.TreeNode;

// 988. Smallest String Starting From Leaf
public class SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    public String dfs(TreeNode node, String suffix) {
        if (node == null)
            return suffix;
        suffix = (char) (node.val + 'a') + suffix;
        if (node.left == null && node.right == null)
            return suffix;
        if (node.left == null || node.right == null)
            return node.left == null ? dfs(node.right, suffix) : dfs(node.left, suffix);
        String left = dfs(node.left, suffix);
        String right = dfs(node.right, suffix);
        return left.compareTo(right) <= 0 ? left : right;
    }
}
