package practice.lintcode;

// 1538. Card Game II
public class CardGameII {
    /**
     * @param cost:        costs of all cards
     * @param damage:      damage of all cards
     * @param totalMoney:  total of money
     * @param totalDamage: the damage you need to inflict
     * @return: Determine if you can win the game
     */
    public boolean cardGame(int[] cost, int[] damage, int totalMoney, int totalDamage) {
        // Write your code here
        int[] dp = new int[totalMoney + 1];
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            for (int j = totalMoney; j >= cost[i]; j--) {
                if (dp[j] < dp[j - cost[i]] + damage[i])
                    dp[j] = dp[j - cost[i]] + damage[i];
            }
        }
        return dp[totalMoney] >= totalDamage ? true : false;
    }

    public boolean cardGameTwo(int[] cost, int[] damage, int totalMoney, int totalDamage) {
        int n = cost.length;
        int[][] dp = new int[cost.length + 1][totalMoney + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalMoney; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (j < cost[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i - 1]] + damage[i - 1]);
            }
        }
        return dp[n][totalMoney] >= totalDamage ? true : false;
    }
}
