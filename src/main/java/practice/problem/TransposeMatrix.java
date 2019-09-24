package practice.problem;

// 867. Transpose Matrix
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] B = new int[n][m];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
