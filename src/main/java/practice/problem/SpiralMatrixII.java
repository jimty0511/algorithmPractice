package practice.problem;

// 59. Spiral Matrix II
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0)
            return result;
        int colStart = 0, rowStart = 0, colEnd = n - 1, rowEnd = n - 1, num = 1;
        while (colStart <= colEnd && rowStart <= rowEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result[rowStart][i] = num++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                result[i][colEnd] = num++;
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                if (rowStart <= rowEnd)
                    result[rowEnd][i] = num++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                if (colStart <= colEnd)
                    result[i][colStart] = num++;
            }
            colStart++;
        }
        return result;
    }
}
