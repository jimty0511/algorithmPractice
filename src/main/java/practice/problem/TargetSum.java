package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 494. Target Sum
public class TargetSum {

    public int findTargetSumWaysDp(int[] nums, int S) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (S > sum || S < -sum)
            return 0;
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] next = new int[2 * sum + 1];
            for (int k = 0; k < 2 * sum + 1; k++) {
                if (dp[k] != 0) {
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum + S];
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        return helper(nums, 0, 0, S, new HashMap<>());
    }

    private int helper(int[] nums, int index, int sum, int S, Map<String, Integer> map) {
        String str = index + "->" + sum;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        if (index == nums.length) {
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
        }
        int curNum = nums[index];
        int add = helper(nums, index + 1, sum - curNum, S, map);
        int minus = helper(nums, index + 1, sum + curNum, S, map);
        map.put(str, add + minus);
        return add + minus;
    }

    private int res = 0;

    public int findTargetSumWaysTwo(int[] nums, int S) {
        helper(nums, 0, 0, S);
        return res;
    }

    private void helper(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                res++;
        } else {
            helper(nums, i + 1, sum + nums[i], S);
            helper(nums, i + 1, sum - nums[i], S);
        }
    }

    boolean result;

    public boolean arithmeticBoggle(int magicNumber, ArrayList<Integer> numbers) {
        // Fill in the code here
        arithmeticBoggleHelper(numbers, 0, 0, magicNumber);
        return result;
    }

    private void arithmeticBoggleHelper(List<Integer> numbers, int i, int sum, int magicNumber) {
        if (i == numbers.size()) {
            if (sum == magicNumber) {
                result = true;
            }
        } else {
            arithmeticBoggleHelper(numbers, i + 1, sum + numbers.get(i), magicNumber);
            arithmeticBoggleHelper(numbers, i + 1, sum - numbers.get(i), magicNumber);
        }
    }
}
