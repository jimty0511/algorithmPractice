package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 54. Spiral Matrix
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = 0;
        while (row < n && col < m) {
            for (int i = col; i < m; i++) {
                result.add(matrix[row][i]);
            }
            row++;
            for (int i = row; i < n; i++) {
                result.add(matrix[i][m - 1]);
            }
            m--;
            if (row < n) {
                for (int i = m - 1; i >= col; i--) {
                    result.add(matrix[n - 1][i]);
                }
                n--;
            }
            if (col < m) {
                for (int i = n - 1; i >= row; i--) {
                    result.add(matrix[i][col]);
                }
                col++;
            }
        }
        return result;
    }
}
