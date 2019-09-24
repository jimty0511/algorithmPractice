package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        if (root == null)
            return;
        int tmp = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(root.left, sb, res);
            helper(root.right, sb, res);
        }
        sb.setLength(tmp);
    }

    public List<String> binaryTreePathsIter(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> treeQ = new LinkedList<>();
        Queue<String> sQ = new LinkedList<>();
        treeQ.offer(root);
        sQ.offer(Integer.toString(root.val));
        while (!treeQ.isEmpty()) {
            TreeNode node = treeQ.poll();
            String path = sQ.poll();
            if (node.left == null && node.right == null)
                res.add(path);
            if (node.left != null) {
                treeQ.offer(node.left);
                sQ.offer(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                treeQ.offer(node.right);
                sQ.offer(path + "->" + Integer.toString(node.right.val));
            }
        }
        return res;
    }
}
