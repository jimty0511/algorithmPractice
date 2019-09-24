package practice.domain;

// 308. Range Sum Query 2D - Mutable
public class NumMatrixII {

    /**
     * colSums way
     */
//    int[][] colSums;
//    int[][] matrix;
//
//    public NumMatrixII(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return;
//        this.matrix = matrix;
//        int m = matrix.length, n = matrix[0].length;
//        colSums = new int[m + 1][n];
//        for (int i = 1; i <= m; i++) {
//            for (int j = 0; j < n; j++) {
//                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
//            }
//        }
//    }
//
//    public void update(int row, int col, int val) {
//        for (int i = row + 1; i < colSums.length; i++) {
//            colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
//        }
//        matrix[row][col] = val;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int res = 0;
//        for (int j = col1; j <= col2; j++) {
//            res += colSums[row2 + 1][j] - colSums[row1][j];
//        }
//        return res;
//    }


    /**
     * rowSums way
     */
//    int[][] rowSums;
//    int[][] matrix;
//
//    public NumMatrixII(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return;
//        this.matrix = matrix;
//        int m = matrix.length, n = matrix[0].length;
//        rowSums = new int[m][n + 1];
//        for (int i = 0; i < m; i++) {
//            for (int j = 1; j <= n; j++) {
//                rowSums[i][j] = rowSums[i][j - 1] + matrix[i][j - 1];
//            }
//        }
//    }
//
//    public void update(int row, int col, int val) {
//        for (int i = col + 1; i < rowSums[0].length; i++) {
//            rowSums[row][i] = rowSums[row][i] - matrix[row][col] + val;
//        }
//        matrix[row][col] = val;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int res = 0;
//        for (int j = row1; j <= row2; j++) {
//            res += rowSums[j][col2 + 1] - rowSums[j][col1];
//        }
//        return res;
//    }

    /**
     * BIT way
     */
    int[][] tree;
    int[][] nums;
    int m;
    int n;

    public NumMatrixII(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m + 1][n + 1];
        nums = matrix;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                init(i, j, matrix[i][j]);
            }
        }
    }

    private void init(int row, int col, int val) {
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += val;
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        init(row, col, diff);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0)
            return 0;
        return getSum(row2 + 1, col2 + 1) + getSum(row1, col1) - getSum(row1, col2 + 1) - getSum(row2 + 1, col1);
    }

    private int getSum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= (i & -i)) {
            for (int j = col; j > 0; j -= (j & -j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
