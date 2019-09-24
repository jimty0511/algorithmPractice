package practice.problem;

// 1000. Minimum Cost to Merge Stones
public class MinimumCostToMergeStones {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) > 0)
            return -1;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int m = K; m <= n; m++) {
            for (int i = 0; i + m <= n; i++) {
                int j = i + m - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                }
                if ((j - i) % (K - 1) == 0)
                    dp[i][j] += preSum[j + 1] - preSum[i];
            }
        }
        return dp[0][n - 1];
    }
}
