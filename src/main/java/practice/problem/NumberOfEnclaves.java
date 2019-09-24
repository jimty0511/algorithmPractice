package practice.problem;

// 1020. Number of Enclaves
public class NumberOfEnclaves {
    public int numEnclaves(int[][] A) {
        int res = 0, m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1)
                    helper(A, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1)
                    res++;
            }
        }
        return res;
    }

    private void helper(int[][] A, int i, int j) {
        if (i >= 0 && i < A.length && j >= 0 && j < A[0].length && A[i][j] == 1) {
            A[i][j] = 0;
            helper(A, i + 1, j);
            helper(A, i - 1, j);
            helper(A, i, j + 1);
            helper(A, i, j - 1);
        }
    }
}
