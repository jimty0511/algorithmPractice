package practice.problem;

// 750. Number Of Corner Rectangles
public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int count = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1)
                        count++;
                }
                if (count > 0)
                    ans += count * (count - 1) / 2;
            }
        }
        return ans;
    }

    public int countCornerRectanglesDp(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1)
                    continue;
                for (int k = j + 1; k < n; k++) {
                    if (grid[i][k] == 1) {
                        res += dp[j][k];
                        dp[j][k]++;
                    }
                }
            }
        }
        return res;
    }
}
