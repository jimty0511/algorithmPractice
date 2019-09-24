package practice.problem;

// 803. Bricks Falling When Hit
public class BricksFallingWhenHit {

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        if (hits == null || hits.length == 0)
            return null;
        int[] res = new int[hits.length];
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return res;
        int m = grid.length, n = grid[0].length;
        for (int k = 0; k < hits.length; k++) {
            int x = hits[k][0], y = hits[k][1];
            if (grid[x][y] == 1)
                grid[x][y] = -1;
        }
        markBricks(grid);
        for (int k = hits.length - 1; k >= 0; k--) {
            int x = hits[k][0], y = hits[k][1];
            if (grid[x][y] == 0)
                res[k] = 0;
            else {
                grid[x][y] = 1;
                if (!attachedToRoof(grid, x, y))
                    continue;
                res[k] = dfs(grid, x, y) - 1;
            }
        }
        return res;
    }

    private void markBricks(int[][] grid) {
        int n = grid[0].length;
        for (int j = 0; j < n; j++)
            dfs(grid, 0, j);
    }

    private int dfs(int[][] grid, int i, int j) {
        if (grid[i][j] != 1)
            return 0;
        int m = grid.length, n = grid[0].length;
        int count = 1;
        grid[i][j] = 2;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1)
                continue;
            count += dfs(grid, x, y);
        }
        return count;
    }

    private boolean attachedToRoof(int[][] grid, int i, int j) {
        if (i == 0)
            return true;
        int m = grid.length, n = grid[0].length;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= m || y < 0 || y >= n)
                continue;
            if (grid[x][y] == 2)
                return true;
        }
        return false;
    }
}
