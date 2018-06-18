package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 366. Find Leaves of Binary Tree
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private int helper(TreeNode root, List<List<Integer>> res) {
        if (root == null)
            return -1;
        int leftLevel = helper(root.left, res);
        int rightLevel = helper(root.right, res);
        int level = Math.max(leftLevel, rightLevel) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        root.left = root.right = null;
        return level;
    }
}
