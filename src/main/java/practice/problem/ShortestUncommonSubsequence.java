package practice.problem;

import java.util.Arrays;

public class ShortestUncommonSubsequence {
    public int solution(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        int m = s.length, n = t.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 1;
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s[i - 1];
                int k;
                for (k = j - 1; k >= 0; k--) {
                    if (t[k] == c)
                        break;
                }
                if (k == -1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][k] + 1);
            }
        }
        return dp[m][n] == Integer.MAX_VALUE ? -1 : dp[m][n];
    }
}
