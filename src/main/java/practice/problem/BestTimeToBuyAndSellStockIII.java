package practice.problem;

import java.util.Arrays;

// 123. Best Time to Buy and Sell Stock III
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE, firstSell = 0;
        int secondBuy = Integer.MAX_VALUE, secondSell = 0;
        for (int p : prices) {
            firstBuy = Math.min(firstBuy, p);
            firstSell = Math.max(firstSell, p - firstBuy);
            secondBuy = Math.min(secondBuy, p - firstSell);
            secondSell = Math.max(secondSell, p - secondBuy);
        }
        return secondSell;
    }

    public int maxProfitTwo(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[] dp = new int[3], min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - dp[k - 1]);
                dp[k] = Math.max(dp[k], prices[i] - min[k]);
            }
        }
        return dp[2];
    }

    public int maxProfitThree(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int k = 2, n = prices.length;
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