package practice.problem;

import java.util.Arrays;

// 903. Valid Permutations for DI Sequence
public class ValidPermutationsForDISequence {
    public int numPermsDISequence(String S) {
        int n = S.length(), mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (S.charAt(i - 1) == 'D') {
                    // add all string with length i - 1 and last digit is greater than or equal to j
                    for (int k = j; k < i; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                } else {
                    // add all string with length i - 1 and last digit is smaller than j
                    for (int k = 0; k < j; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j <= n; j++) {
            res += dp[n][j];
            res %= mod;
        }
        return res;
    }

    public int numPermsDISequenceTwo(String S) {
        int n = S.length(), mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = j == 0 ? 0 : dp[i][j - 1];
                if (S.charAt(i - 1) == 'D') {
                    dp[i][j] += (dp[i - 1][i - 1] - (j == 0 ? 0 : dp[i - 1][j - 1])) % mod;
                    if (dp[i][j] < 0)
                        dp[i][j] += mod;
                } else {
                    dp[i][j] += j == 0 ? 0 : dp[i - 1][j - 1];
                }
                dp[i][j] %= mod;
            }
        }
        return dp[n][n];
    }
}
