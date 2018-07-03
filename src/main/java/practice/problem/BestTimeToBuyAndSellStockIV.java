package practice.problem;

// 188. Best Time to Buy and Sell Stock IV
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            int max = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    max += prices[i] - prices[i - 1];
            }
            return max;
        }
        int[][] dp = new int[k + 1][n];
        int localMax = Integer.MIN_VALUE;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                localMax = Math.max(localMax, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], localMax + prices[j]);
            }
            localMax = Integer.MIN_VALUE;
        }
        return dp[k][n - 1];
    }
}
