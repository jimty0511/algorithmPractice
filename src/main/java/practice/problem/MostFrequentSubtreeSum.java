package practice.problem;

import practice.domain.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 508. Most Frequent Subtree Sum
public class MostFrequentSubtreeSum {

    Map<Integer, Integer> count = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (int key : count.keySet()) {
            if (count.get(key) == max)
                res.add(key);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int sum = dfs(root.left) + dfs(root.right) + root.val;
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        max = Math.max(max, count.get(sum));
        return sum;
    }
}
