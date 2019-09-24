package practice.lintcode;

// 944. Maximum Submatrix
public class MaximumSubmatrix {
    public int maxSubmatrix(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + matrix[i - 1][j - 1];
            }
        }
        int max = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = i + 1; j <= n; j++) {
                int cur = 0;
                for (int k = 1; k <= n; k++) {
                    cur += (sum[j][k] - sum[i][k]);
                    max = Math.max(cur, max);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return max;
    }
}
