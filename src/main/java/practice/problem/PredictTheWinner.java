package practice.problem;

// 486. Predict the Winner
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1, new int[nums.length][nums.length]) >= 0;
    }

    private int helper(int[] nums, int left, int right, int[][] memo) {
        if (left == right)
            return nums[left];
        if (memo[left][right] != 0)
            return memo[left][right];
        int chooseLeft = nums[left] - helper(nums, left + 1, right, memo);
        int chooseRight = nums[right] - helper(nums, left, right - 1, memo);
        int curr = Math.max(chooseLeft, chooseRight);
        memo[left][right] = curr;
        return curr;
    }

    public boolean PredictTheWinnerDp(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public boolean PredictTheWinnerDpOne(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j)
                    dp[i] = nums[i];
                else
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }
}