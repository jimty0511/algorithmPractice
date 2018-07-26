package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 257. Binary Tree Paths
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        StringBuilder sb = new StringBuilder();
        helper(root, sb, res);
        return res;
    }

    private void helper(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) return;
        int tmp = sb.length();
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            sb.delete(tmp, sb.length());
            return;
        }
        sb.append(root.val + "->");
        helper(root.left, sb, res);
        helper(root.right, sb, res);
        sb.delete(tmp, sb.length());
        return;
    }
}
