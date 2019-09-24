package practice.problem;

import java.util.Arrays;

// 940. Distinct Subsequences II
public class DistinctSubsequencesII {
    public int distinctSubseqII(String S) {
        int n = S.length(), M = (int) 1e9 + 7, sum = 0;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            int idx = S.charAt(i) - 'a';
            int cur = (1 + sum - count[idx] + M) % M;
            sum = (sum + cur) % M;
            count[idx] = (count[idx] + cur) % M;
        }
        return sum;
    }

    public int distinctSubseqIITwo(String S) {
        int n = S.length(), MOD = (int) 1e9 + 7, res = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (S.charAt(i) != S.charAt(j)) {
                    dp[i] += dp[j];
                    dp[i] %= MOD;
                }
            }
            res += dp[i];
            res %= MOD;
        }
        return res;
    }

    public int distinctSubseqIIThree(String S) {
        int n = S.length(), MOD = (int) 1e9 + 7, res = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            int idx = S.charAt(i) - 'a';
            dp[i] += res - count[idx];
            dp[i] = (dp[i] + MOD) % MOD;
            res = (res + dp[i]) % MOD;
            count[idx] = (count[idx] + dp[i]) % MOD;
        }
        return res;
    }
}
