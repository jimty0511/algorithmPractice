package practice.problem;

import practice.domain.TreeNode;

import java.util.Stack;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        traverse(root1, sb1);
        traverse(root2, sb2);
        return sb1.toString().equals(sb2.toString());
    }

    private void traverse(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            sb.append(root.val).append("-");
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    public boolean leafSimilarStack(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (dfs(s1) != dfs(s2))
                return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }

    private int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
            if (node.left == null && node.right == null)
                return node.val;
        }
    }
}
