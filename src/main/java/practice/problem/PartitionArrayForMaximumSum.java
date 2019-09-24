package practice.problem;

// 1043. Partition Array for Maximum Sum
public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; k++) {
                curMax = Math.max(curMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[n - 1];
    }
}
