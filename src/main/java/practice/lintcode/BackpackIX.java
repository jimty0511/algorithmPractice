package practice.lintcode;

import java.util.Arrays;

// 800. Backpack IX
public class BackpackIX {
    /**
     * @param n:           Your money
     * @param prices:      Cost of each university application
     * @param probability: Probability of getting the University's offer
     * @return: the  highest probability
     */
    public double backpackIX(int n, int[] prices, double[] probability) {
        // write your code here
        double[] dp = new double[n + 1];
        Arrays.fill(dp, 1.0);
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1 - probability[i];
        }
        dp[0] = 1.0;
        for (int i = 0; i < probability.length; i++) {
            for (int j = n; j >= prices[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - prices[i]] * probability[i]);
            }
        }
        return 1 - dp[n];
    }
}
