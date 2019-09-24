package practice.problem;

import java.util.Arrays;

// 576. Out of Boundary Paths
public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0)
            return 0;
        final int MOD = 1000000007;
        int[][] dp1 = new int[m][n];
        dp1[i][j] = 1;
        int result = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int step = 0; step < N; step++) {
            int[][] dp2 = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir : dirs) {
                        int row = r + dir[0];
                        int col = c + dir[1];
                        if (row < 0 || row >= m || col < 0 || col >= n) {
                            result = (result + dp1[r][c]) % MOD;
                        } else {
                            dp2[row][col] = (dp2[row][col] + dp1[r][c]) % MOD;
                        }
                    }
                }
            }
            dp1 = dp2;
        }
        return result;
    }

    private int MOD = (int) 1e9 + 7;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int findPathsTwo(int m, int n, int N, int i, int j) {
        long[][][] memo = new long[m][n][N + 1];
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                Arrays.fill(memo[ii][jj], -1);
            }
        }
        return (int) (dfs(m, n, N, i, j, memo) % MOD);
    }

    private long dfs(int m, int n, int N, int i, int j, long[][][] memo) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 1;
        if (N == 0)
            return 0;
        if (memo[i][j][N] != -1)
            return memo[i][j][N];
        memo[i][j][N] = 0;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            memo[i][j][N] = (memo[i][j][N] + dfs(m, n, N - 1, x, y, memo) % MOD) % MOD;
        }
        return memo[i][j][N];
    }
}
