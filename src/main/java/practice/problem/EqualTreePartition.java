package practice.problem;

import practice.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 663. Equal Tree Partition (864 LC)
public class EqualTreePartition {

    private Map<Integer, Integer> map = new HashMap<>();

    public boolean checkEqualTree(TreeNode root) {
        // write your code here
        int sum = dfs(root);
        if (sum == 0)
            return map.get(0) > 1;
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
