package practice.domain;

// 304. Range Sum Query 2D - Immutable
public class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            dp = new int[0][0];
        else
            dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int val = matrix[i][j];
                if (i - 1 >= 0)
                    val += dp[i - 1][j];
                if (j - 1 >= 0)
                    val += dp[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0)
                    val -= dp[i - 1][j - 1];
                dp[i][j] = val;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = dp[row2][col2];
        if (row1 - 1 >= 0)
            sum -= dp[row1 - 1][col2];
        if (col1 - 1 >= 0)
            sum -= dp[row2][col1 - 1];
        if (row1 - 1 >= 0 && col1 - 1 >= 0)
            sum += dp[row1 - 1][col1 - 1];
        return sum;
    }
}
