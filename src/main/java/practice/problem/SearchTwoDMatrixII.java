package practice.problem;

// 240. Search a 2D Matrix II
public class SearchTwoDMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;
        int row = 0, col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    // 38 LC
    // Microsoft ladder
    public int searchMatrixLC(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = 0, col = matrix[0].length - 1, count = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                count++;
                row++;
                col--;
            }
        }
        return count;
    }
}
