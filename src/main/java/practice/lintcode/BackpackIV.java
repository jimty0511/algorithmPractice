package practice.lintcode;

// 562. Backpack IV
public class BackpackIV {
    /**
     * @param nums:   an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackIV(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = n; i <= target; i++) {
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }

    public int backPackIVTwo(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1])
                    dp[i][j] += dp[i][j - nums[i - 1]];
            }
        }
        return dp[n][target];
    }

}
