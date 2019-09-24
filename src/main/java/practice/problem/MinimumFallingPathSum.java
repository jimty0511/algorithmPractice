package practice.problem;

// 931. Minimum Falling Path Sum
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++)
            dp[0][j] = A[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                }
                dp[i][j] += A[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int v : dp[m - 1]) {
            min = Math.min(v, min);
        }
        return min;
    }
}
