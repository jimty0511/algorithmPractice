package practice.problem;

// 861. Score After Flipping Matrix
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int res = 0;
        res += (1 << (n - 1)) * m;
        for (int j = 1; j < n; j++) {
            int same = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == A[i][j])
                    same++;
            }
            res += Math.max(same, m - same) * (1 << (n - 1 - j));
        }
        return res;
    }
}
