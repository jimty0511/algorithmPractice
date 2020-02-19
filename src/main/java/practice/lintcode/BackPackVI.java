package practice.lintcode;

// 564. Combination Sum IV
public class BackPackVI {
    /**
     * @param nums:   an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n)
                    dp[i] += dp[i - n];
            }
        }
        return dp[target];

//        int[] dp = new int[target + 1];
//        dp[0] = 1;
//        for (int n : nums) {
//            for (int j = n; j <= target; j++) {
//                dp[j] += dp[j - n];
//            }
//        }
//        return dp[target];
    }

    public int backPackVITwo(int[] nums, int target) {
        // write your code here
        int n = nums.length;
        int[][] dp = new int[target + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= nums[j - 1])
                    dp[i][j] += dp[i - nums[j - 1]][n];
            }
        }
        return dp[target][n];
    }
}
