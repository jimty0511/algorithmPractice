package practice.problem;

// 959. Regions Cut By Slashes
public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int cnt = 0;
        int[][] g = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    g[i * 3][j * 3 + 2] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    g[i * 3][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 0) {
                    dfs(g, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int[][] g, int i, int j) {
        int n = g.length;
        if (i < 0 || i >= n || j < 0 || j >= n || g[i][j] == 1)
            return;
        g[i][j] = 1;
        for (int[] d : dirs)
            dfs(g, i + d[0], j + d[1]);
    }
}
