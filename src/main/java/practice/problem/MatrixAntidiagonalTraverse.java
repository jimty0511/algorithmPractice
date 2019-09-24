package practice.problem;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/discuss/interview-question/346342/Facebook-or-Onsite-or-Matrix-Antidiagonal-Traverse
public class MatrixAntidiagonalTraverse {
    public List<List<Integer>> solution(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<List<Integer>> res = new ArrayList<>();
        int colStart = 0, rowStart = 0, i = 0, j = 0;
        while (rowStart < m && colStart < n) {
            List<Integer> tmp = new ArrayList<>();
            i = rowStart;
            j = colStart;
            while (i >= 0 && i < m && j >= 0 && j < n) {
                tmp.add(matrix[i][j]);
                i++;
                j--;
            }
            res.add(tmp);
            if (colStart == n - 1)
                rowStart++;
            else
                colStart++;
        }
        return res;
    }
}
