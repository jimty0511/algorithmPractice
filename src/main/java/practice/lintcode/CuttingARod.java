package practice.lintcode;

public class CuttingARod {
    /**
     * @param prices: the prices
     * @param n:      the length of rod
     * @return: the max value
     */
    public int cutting(int[] prices, int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= n; j++) {
//                if (j >= i)
//                    dp[j] = Math.max(dp[j], dp[j - i] + prices[i - 1]);
//            }
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] + prices[i - 1]);
            }
        }
        return dp[n];
    }

}
