package practice.problem;

import java.util.Arrays;

// 935. Knight Dialer
public class KnightDialer {

    private int MOD = (int) 1e9 + 7;
    private int[][] graph = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

    public int knightDialer(int N) {
        int cnt = 0;
        Integer[][] memo = new Integer[N + 1][10];
        for (int i = 0; i <= 9; i++) {
            cnt = (cnt + helper(N - 1, i, memo)) % MOD;
        }
        return cnt;
    }

    private int helper(int N, int cur, Integer[][] memo) {
        if (N == 0)
            return 1;
        if (memo[N][cur] != null)
            return memo[N][cur];
        int cnt = 0;
        for (int next : graph[cur]) {
            cnt = (cnt + helper(N - 1, next, memo)) % MOD;
        }
        memo[N][cur] = cnt;
        return cnt;
    }

    public int knightDialerDp(int N) {
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        for (int n = N; n > 1; n--) {
            int[] temp = new int[10];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    int pos = graph[i][j];
                    temp[pos] = (temp[pos] + dp[i]) % MOD;
                }
            }
            dp = temp;
        }
        int ans = 0;
        for (int n : dp)
            ans = (ans + n) % MOD;
        return ans;
    }
}
