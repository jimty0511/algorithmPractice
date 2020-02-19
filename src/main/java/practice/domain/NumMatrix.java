package practice.domain;

// 304. Range Sum Query 2D - Immutable
public class NumMatrix {

    private int[][] dp;

//    public NumMatrix(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return;
//        int m = matrix.length, n = matrix[0].length;
//        dp = new int[m + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
//            }
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int rMin = Math.min(row1, row2);
//        int rMax = Math.max(row1, row2);
//        int cMin = Math.min(col1, col2);
//        int cMax = Math.max(col1, col2);
//        return dp[rMax + 1][cMax + 1] - dp[rMax + 1][cMin] - dp[rMin][cMax + 1] + dp[rMin][cMin];
    //dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
//    }

    public NumMatrix(int[][] matrix) {
        dp = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int left = j == 0 ? 0 : dp[i][j - 1];
                int up = i == 0 ? 0 : dp[i - 1][j];
                int corner = (i == 0 || j == 0) ? 0 : dp[i - 1][j - 1];
                dp[i][j] += (left + up - corner);
            }
        }
    }

    public int sumRegionTwo(int row1, int col1, int row2, int col2) {
        int up = row1 > 0 ? dp[row1 - 1][col2] : 0;
        int left = col1 > 0 ? dp[row2][col1 - 1] : 0;
        int corner = (row1 > 0 && col1 > 0) ? dp[row1 - 1][col1 - 1] : 0;
        return dp[row2][col2] - left - up + corner;
    }
}
