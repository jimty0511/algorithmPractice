package practice.lintcode;

// 801. Backpack X
public class BackpackX {
    /**
     * @param n: the money you have
     * @return: the minimum money you have to give
     */
    public int backPackX(int n) {
        // write your code here
        int[] prices = {150, 250, 350};
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= prices[i - 1])
                    dp[j] = Math.max(dp[j], dp[j - prices[i - 1]] + prices[i - 1]);
            }
        }
        return n - dp[n];
    }

    public int backPackXTwo(int n) {
        // write your code here
        int[] prices = {150, 250, 350};
        int[][] dp = new int[4][n + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= n; j++) {
                // dp[i][j] = dp[i-1][j];
                if (j >= prices[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - prices[i - 1]] + prices[i - 1]);
                }
            }
        }
        return n - dp[3][n];
    }
}
