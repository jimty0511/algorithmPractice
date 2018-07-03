package practice.problem;

// 312. Burst Balloons
public class BurstBallons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = newNums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return helper(newNums, dp, 1, n);
    }

    private int helper(int[] nums, int[][] dp, int start, int end) {
        if (start > end)
            return 0;
        if (dp[start][end] > 0)
            return dp[start][end];
        for (int i = start; i <= end; i++) {
            int value = nums[start - 1] * nums[i] * nums[end + 1] + helper(nums, dp, start, i - 1) + helper(nums, dp, i + 1, end);
            dp[start][end] = Math.max(dp[start][end], value);
        }
        return dp[start][end];
    }
}
