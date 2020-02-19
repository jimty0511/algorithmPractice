package practice.problem;

// 48. Rotate Image
// Microsoft ladder
public class RotateImage {
    public void rotate(int[][] matrix) {
        int l = matrix[0].length, tmp;
        for (int r = 0; r < l; r++) {
            for (int c = r; c < l - r - 1; c++) {
                tmp = matrix[c][l - r - 1];
                matrix[c][l - r - 1] = matrix[r][c];
                matrix[r][c] = matrix[l - 1 - c][r];
                matrix[l - 1 - c][r] = matrix[l - 1 - r][l - 1 - c];
                matrix[l - 1 - r][l - 1 - c] = tmp;
            }
        }
    }

    // clockwise
    public void rotateTwo(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int row = matrix.length, col = matrix[0].length;
        int low = 0, high = col - 1;
        while (low < high) {
            int[] temp = matrix[low];
            matrix[low] = matrix[high];
            matrix[high] = temp;
            low++;
            high--;
        }
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // anticlockwise
    public void rotateThree(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++;
                right--;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
