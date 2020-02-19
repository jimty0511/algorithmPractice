package practice.problem;

import java.util.Arrays;

// 518. Coin Change 2
// Microsoft ladder
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

//    public int change(int total, int[] coins, int[] amount) {
//        int m = coins.length;
//        int[] dp = new int[total + 1];
////        dp[0] = 1;
//        for (int i = 0; i < m; i++) {
//            for (int k = 1; k <= amount[i]; k++) {
//                for (int j = total; j >= 0; j--) {
//                    int cur = j + coins[i];
//                    if (cur <= total) {
//                        if (dp[cur] > dp[j] + 1)
//                            dp[cur] = dp[j] + 1;
//                    }
//                }
//            }
//        }
//        return dp[total];
//    }
}
