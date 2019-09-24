package practice.problem;

// 813. Largest Sum of Averages
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length, sum = 0;
        double[][] dp = new double[K + 1][len + 1];
        int[] sums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum += A[i];
            sums[i + 1] = sum;
            dp[1][i + 1] = (double) sum / (i + 1);
        }
        for (int k = 2; k <= K; k++) {
            for (int i = 1; i <= len; i++) {
                for (int j = 1; j < i; j++) {
                    dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + (double) (sums[i] - sums[j]) / (i - j));
                }
            }
        }
        return dp[K][len];
    }
}
