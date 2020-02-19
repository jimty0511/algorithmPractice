package practice.lintcode;

// 1682. Minimum Path Sum III
public class MinimumPathSumIII {
    /**
     * @param grid:
     * @return: nothing
     */
    public int minimumPathSumIII(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                else if (i == 0 && j != 0)
                    grid[i][j] += grid[i][j - 1];
                else if (i != 0 && j == 0)
                    grid[i][j] += grid[i - 1][j];
                else
                    grid[i][j] += Math.min(grid[i - 1][j - 1], Math.min(grid[i - 1][j], grid[i][j - 1]));
            }
        }
        return grid[m - 1][n - 1];
    }
}
