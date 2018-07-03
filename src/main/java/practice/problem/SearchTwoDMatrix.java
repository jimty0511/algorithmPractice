package practice.problem;

// 74. Search a 2D Matrix
public class SearchTwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }

    public boolean searchMatrixTwo(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length, col = matrix[0].length;
        int begin = 0, end = row * col - 1;
        while (begin <= end) {
            int mid = begin + (end - begin / 2);
            int midValue = matrix[mid / col][mid % col];
            if (midValue == target)
                return true;
            else if (midValue < target)
                begin = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
