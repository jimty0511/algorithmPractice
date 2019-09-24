package practice.problem;

import java.util.Arrays;

// 646. Maximum Length of Pair Chain
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int pre = pairs[0][1];
        int count = 1;
        for (int[] pair : pairs) {
            if (pair[0] > pre) {
                count++;
                pre = pair[1];
            }
        }
        return count;
    }

    public int findLongestChainDp(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
            }
        }
        return dp[pairs.length - 1];
    }
}
