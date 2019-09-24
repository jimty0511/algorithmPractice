package practice.problem;

import java.util.Arrays;

// 300. Longest Increasing Subsequence
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int n : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < n) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = n;
            if (i == size)
                ++size;
        }
        return size;
    }

    public int lengthOfLISdp(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
