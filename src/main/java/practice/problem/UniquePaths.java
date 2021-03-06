package practice.problem;

import java.util.Arrays;

// 62. Unique Paths
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    public int uniquePathsTwo(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++)
                dp[j] += dp[j - 1];
        }
        return dp[m - 1];
    }

    public int uniquePathsThree(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++)
                dp[j] += dp[j - 1];
        }
        return dp[n - 1];
    }
}
