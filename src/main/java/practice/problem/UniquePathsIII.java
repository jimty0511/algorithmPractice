package practice.problem;

// 980. Unique Paths III
public class UniquePathsIII {
    int res = 0, empty = 1, sx, sy, ex, ey;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] < 0)
            return;
        if (i == ex && j == ey) {
            if (empty == 0)
                res++;
            return;
        }
        grid[i][j] = -2;
        empty--;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        grid[i][j] = 0;
        empty++;
    }
}
