package practice.problem;

// 718. Maximum Length of Repeated Subarray
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null)
            return 0;
        int m = A.length, n = B.length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max;
    }
}