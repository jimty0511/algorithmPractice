package practice.lintcode;

// 798. Backpack VII
public class BackPackVII {
    /**
     * @param n:       the money of you
     * @param prices:  the price of rice[i]
     * @param weight:  the weight of rice[i]
     * @param amounts: the amount of rice[i]
     * @return: the maximum weight
     */
    public int backPackVII(int n, int[] prices, int[] weight, int[] amounts) {
        // write your code here
        int m = prices.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int k = 1; k <= amounts[i]; k++) {
                for (int j = n; j >= prices[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - prices[i]] + weight[i]);
                }
            }
        }
        return dp[n];
    }

    public int backPackVIITwo(int n, int[] prices, int[] weight, int[] amounts) {
        // write your code here
        int len = prices.length;
        int[][] dp = new int[len + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            for (int k = 1; k <= amounts[i - 1]; k++) {
                for (int j = 0; j <= n; j++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    if (j >= k * prices[i - 1])
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * prices[i - 1]] + k * weight[i - 1]);
                }
            }
        }
        return dp[len][n];
    }
}
