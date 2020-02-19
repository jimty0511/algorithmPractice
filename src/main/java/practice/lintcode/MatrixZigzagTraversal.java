package practice.lintcode;

// 185. Matrix Zigzag Traversal
public class MatrixZigzagTraversal {
    /**
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0;
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if (c == n - 1)
                    r++;
                else if (r == 0)
                    c++;
                else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1)
                    c++;
                else if (c == 0)
                    r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
