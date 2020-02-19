package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 1155. Number of Dice Rolls With Target Sum
public class NumberOfDiceRollsWithTargetSum {

    int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int d, int f, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(d, f, target, memo);
    }

    private int helper(int d, int f, int target, Map<String, Integer> memo) {
        if (d == 0 && target == 0)
            return 1;
        if (d == 0 || target == 0)
            return 0;
        String str = d + " " + target;
        if (memo.containsKey(str))
            return memo.get(str);
        int res = 0;
        for (int i = 1; i <= f; i++) {
            if (target >= i) {
                res = (res + helper(d - 1, f, target - i, memo)) % MOD;
            } else {
                break;
            }
        }
        memo.put(str, res);
        return res;
    }

    public int numRollsToTargetDp(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                if (j > i * f)
                    break;
                else {
                    for (int k = 1; k <= f && k <= j; k++)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }
        return dp[d][target];
    }
}
