package practice.lintcode;

// 395. Coins in a Line II
public class CoinsInALineII {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0)
            return false;
        if (values.length < 3)
            return true;
        int len = values.length;
        int[] dp = new int[len];
        dp[len - 1] = values[len - 1];
        dp[len - 2] = values[len - 1] + values[len - 2];
        for (int i = len - 3; i >= 0; i--) {
            int tmp1 = values[i] - dp[i + 1];
            int tmp2 = values[i] + values[i + 1] - dp[i + 2];
            dp[i] = Math.max(tmp1, tmp2);
        }
        return dp[0] > 0;
    }
}
