package practice.problem;

// https://leetcode.com/discuss/interview-question/341247
public class LeftmostColumnIndexOfOne {
    public int solution(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == 0)
                i++;
            else if (matrix[i][j] == 1)
                j--;
        }
        return j + 1;
    }

    public int solutionTwo(int[][] matrix) {
        int idx = matrix[0].length;
        for (int[] row : matrix) {
            int l = 0, r = row.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (row[mid] == 0)
                    l = mid + 1;
                else
                    r = mid;
            }
            idx = Math.min(idx, l);
        }
        return idx;
    }
}
