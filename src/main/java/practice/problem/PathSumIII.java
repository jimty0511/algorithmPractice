package practice.problem;

import practice.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 437. Path Sum III
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root, int sum, int target, Map<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        sum += root.val;
        int res = preSum.getOrDefault(sum - target, 0);
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        int left = helper(root.left, sum, target, preSum);
        int right = helper(root.right, sum, target, preSum);
        res += left + right;
        preSum.put(sum, preSum.get(sum) - 1);
        return res;
    }

    public int pathSumTwo(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSumTwoHelper(root, sum) + pathSumTwo(root.left, sum) + pathSumTwo(root.right, sum);
    }

    private int pathSumTwoHelper(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return (root.val == sum ? 1 : 0) + pathSumTwoHelper(root.left, sum - root.val) + pathSumTwoHelper(root.right, sum - root.val);
    }
}
