package practice.problem;

// 807. Max Increase to Keep City Skyline
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n], col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        return result;
    }
}
