package practice.problem;

// 887. Super Egg Drop
// https://github.com/Shellbye/Shellbye.github.io/issues/42
public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k - 1][m - 1] + dp[k][m - 1] + 1;
                if (dp[k][m] >= N)
                    return m;
            }
        }
        return N;
    }
}
