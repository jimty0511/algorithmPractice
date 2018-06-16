package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 95. Unique Binary Search Trees II
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int rootValue = start; rootValue <= end; rootValue++) {
            List<TreeNode> leftSubTrees = helper(start, rootValue - 1);
            List<TreeNode> rightSubTrees = helper(rootValue + 1, end);
            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    TreeNode root = new TreeNode(rootValue);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
