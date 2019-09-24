package practice.problem;

// 1039. Minimum Score Triangulation of Polygon
public class MinimumScoreTriangulationOfPolygon {
    public int minScoreTriangulation(int[] A) {
        return dfs(A, 0, A.length - 1, new Integer[A.length][A.length]);
    }

    private int dfs(int[] A, int i, int j, Integer[][] memo) {
        if (j < i + 2)
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(A, i, k, memo) + dfs(A, k, j, memo) + A[i] * A[k] * A[j]);
        }
        memo[i][j] = res;
        return memo[i][j];
    }

    public int minScoreTriangulationDp(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int minScoreTriangulationDpTwo(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int j = 2; j < n; j++) {
            for (int i = j - 2; i >= 0; i--) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
