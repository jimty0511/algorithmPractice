package practice.problem;

public class LongestLineOfConsecutiveOneInMatrix {

    public int longestLineDp(int[][] M) {
        if (M == null || M.length == 0)
            return 0;
        int n = M.length, m = M[0].length;
        int[][][] dp = new int[n][m][4];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 0)
                    continue;
                for (int k = 0; k < 4; k++)
                    dp[i][j][k] = 1;
                if (j > 0)
                    dp[i][j][0] += dp[i][j - 1][0]; //horizontal
                if (i > 0)
                    dp[i][j][1] += dp[i - 1][j][1]; //vertical
                if (i > 0 && j > 0)
                    dp[i][j][2] += dp[i - 1][j - 1][2]; //anti-diagnoal
                if (j < m - 1 && i > 0)
                    dp[i][j][3] += dp[i - 1][j + 1][3];
                res = Math.max(res, Math.max(dp[i][j][0], Math.max(dp[i][j][1], Math.max(dp[i][j][2], dp[i][j][3]))));
            }
        }
        return res;
    }
}
