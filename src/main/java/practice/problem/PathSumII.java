package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 113. Path Sum II
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, sum, result, path);
        return result;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum)
                result.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            helper(root.left, sum - root.val, result, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            helper(root.right, sum - root.val, result, path);
            path.remove(path.size() - 1);
        }
    }
}
