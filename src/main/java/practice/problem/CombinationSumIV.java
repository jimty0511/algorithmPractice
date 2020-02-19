package practice.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 377. Combinations Sum IV
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n)
                    dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4Two(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length == 0 || target < 0)
            return 0;
        if (target == 0)
            return 1;
        if (map.containsKey(target))
            return map.get(target);
        for (int num : nums) {
            count += combinationSum4Two(nums, target - num);
        }
        map.put(target, count);
        return count;
    }

    public int combinationSum4Three(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
            for (int n : nums) {
                if (n > i)
                    break;
                else if (n == i)
                    res[i] += 1;
                else
                    res[i] += res[i - n];
            }
        }
        return res[target];
    }
}
