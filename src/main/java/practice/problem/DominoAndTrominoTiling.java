package practice.problem;

// 790. Domino and Tromino Tiling

//dp[n]=dp[n-1]+dp[n-2]+ 2*(dp[n-3]+...+d[0])
//     =dp[n-1]+dp[n-2]+dp[n-3]+dp[n-3]+2*(dp[n-4]+...+d[0])
//     =dp[n-1]+dp[n-3]+(dp[n-2]+dp[n-3]+2*(dp[n-4]+...+d[0]))
//     =dp[n-1]+dp[n-3]+dp[n-1]
//     =2*dp[n-1]+dp[n-3]
public class DominoAndTrominoTiling {
    public int numTilings(int N) {
        if (N == 1)
            return 1;
        if (N == 2)
            return 2;
        int MOD = (int) 1e9 + 7;
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % MOD;
        }
        return (int) dp[N];
    }

    public int numTilingsTwo(int N) {
        if (N == 1)
            return 1;
        if (N == 2)
            return 2;
        int MOD = (int) 1e9 + 7;
        long[] dpg = new long[N + 1];
        long[] dpu = new long[N + 1];
        dpg[0] = dpu[0] = 0;
        dpg[1] = dpu[1] = 1;
        dpg[2] = dpu[2] = 2;
        for (int i = 3; i <= N; i++) {
            dpu[i] = (dpu[i - 1] + dpg[i - 1]) % MOD;
            dpg[i] = (dpg[i - 1] + dpg[i - 2] + 2 * dpu[i - 2]) % MOD;
        }
        return (int) dpg[N] % MOD;
    }
}
