package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 766. Toeplitz Matrix
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (!map.containsKey(r - c)) {
                    map.put(r - c, matrix[r][c]);
                } else if (map.get(r - c) != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrixTwo(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }
}
