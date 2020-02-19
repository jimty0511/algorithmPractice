package practice.lintcode;

// 92. Backpack
public class BackPack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
        return dp[m];
    }

    public int backPackTwo(int m, int[] A) {
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + A[i - 1]);
                }
            }
        }
        return dp[A.length][m];
    }
}
