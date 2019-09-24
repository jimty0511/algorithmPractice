package practice.lintcode;

// 762. Longest Common Subsequence II
public class LongestCommonSubsequenceII {
    public int longestCommonSubsequence2(int[] P, int[] Q, int k) {
        // Write your code here
        int m = P.length, n = Q.length;
        int[][][] dp = new int[m + 1][n + 1][k + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (P[i - 1] == Q[j - 1])
                    dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
                else
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int d = 1; d <= k; d++) {
                    if (P[i - 1] != Q[j - 1]) {
                        dp[i][j][d] = Math.max(dp[i - 1][j][d], Math.max(dp[i][j - 1][d], dp[i - 1][j - 1][d - 1] + 1));
                    } else {
                        dp[i][j][d] = Math.max(dp[i - 1][j][d], Math.max(dp[i][j - 1][d], dp[i - 1][j - 1][d] + 1));
                    }
                }
            }
        }
        return dp[m][n][k];
    }
}
