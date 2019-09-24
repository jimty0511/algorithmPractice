package practice.problem;

import java.util.List;

// 44. Minimum Subarray LC
public class MinimumSubarray {
    public int minSubArray(List<Integer> nums) {
        // write your code here
        int n = nums.size();
        int[] dp = new int[n];
        int min = nums.get(0);
        dp[0] = min;
        for (int i = 1; i < n; i++) {
            dp[i] = nums.get(i) + (dp[i - 1] > 0 ? 0 : dp[i - 1]);
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
