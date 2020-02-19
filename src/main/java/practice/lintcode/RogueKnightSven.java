package practice.lintcode;

import java.util.Arrays;

// 752. Rogue Knight Sven
public class RogueKnightSven {
    public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        long[][] dp = new long[n + 1][m + 1];
        Arrays.fill(dp[0], 0);
        dp[0][m] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
                for (int t = Math.max(0, i - limit); t <= i - 1; t++) {
                    if (j + cost[i] <= m)
                        dp[i][j] += dp[t][j + cost[i]];
                }
            }
        }
        long ans = 0;
        for (int i = 0; i <= m; i++) {
            ans += dp[n][i];
        }
        return ans;
    }

    public long getNumberOfWaysTwo(int n, int m, int limit, int[] cost) {
        if (limit == 0)
            return 0;
        long[][] dp = new long[n + 1][m + 1];
        for (int j = 0; j <= m; j++)
            dp[0][j] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int k = Math.max(0, i - limit);
                for (; k < i; k++) {
                    if (j >= cost[i])
                        dp[i][j] += dp[k][j - cost[i]];
                }
            }
        }
        return dp[n][m];
    }
}
