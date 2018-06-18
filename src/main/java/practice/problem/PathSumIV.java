package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 666. Path Sum IV
public class PathSumIV {
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        for (int n : nums) {
            int key = n / 10;
            int val = n % 10;
            map.put(key, val);
        }
        helper(nums[0] / 10, 0);
        return sum;
    }

    private void helper(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;
        int curSum = map.get(root) + preSum;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            sum += curSum;
            return;
        }
        if (map.containsKey(left)) {
            helper(left, curSum);
        }
        if (map.containsKey(right)) {
            helper(right, curSum);
        }
    }
}
