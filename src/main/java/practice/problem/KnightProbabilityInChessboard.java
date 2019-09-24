package practice.problem;

import java.util.Arrays;

// 688. Knight Probability in Chessboard
public class KnightProbabilityInChessboard {

    int[][] moves = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp1 = new double[N][N];
        dp1[r][c] = 1;
        for (; K > 0; K--) {
            double[][] dp2 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] move : moves) {
                        int row = i + move[0];
                        int col = j + move[1];
                        if (isLegal(row, col, N))
                            dp2[row][col] += dp1[i][j] / 8.0;
                    }
                }
            }
            dp1 = dp2;
        }
        double ans = 0.0;
        for (double[] row : dp1) {
            for (double val : row) {
                ans += val;
            }
        }
        return ans;
    }

    private boolean isLegal(int r, int c, int N) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
