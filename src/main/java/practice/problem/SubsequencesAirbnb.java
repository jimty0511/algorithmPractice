package practice.problem;

import java.util.*;

public class SubsequencesAirbnb {
    public long maxDownSequencesTwo(List<Integer> prices) {
        if (prices == null || prices.size() <= 2)
            return (long) 0;
        int dp[] = new int[prices.size()];
        Arrays.fill(dp, 1);
        long result = 0;
        for (int i = 1; i < prices.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (prices.get(i) < prices.get(j)) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public long maxDownSequencesThree(List<Integer> prices) {
        if (prices == null || prices.size() <= 2)
            return (long) 0;
        int dp[] = new int[prices.size()];
        Arrays.fill(dp, 1);
        long result = 0;
        for (int i = 1; i < prices.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (prices.get(i) < prices.get(j) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] >= 3)
                        result += dp[i];
                }
            }
        }
        for (int n : dp) {
            if (n >= 3)
                result += n;
        }
        return result;
    }

    long result = 0;

    public long maxDownSequencesFour(List<Integer> prices) {
        for (int i = 0; i < prices.size() - 2; i++) {
            for (int j = i + 1; j < prices.size() - 1; j++) {
                if (prices.get(i) > prices.get(j)) {
//                    int k = j + 1;
//                    dfs(prices, j, k);
                    int k = j + 1, tmp = 0;
                    while (k < prices.size()) {
                        if (prices.get(j) > prices.get(k))
                            tmp++;
                        k++;
                    }
                    result += tmp;
                }
            }
        }
        return result;
    }

    private void dfs(List<Integer> prices, int j, int k) {
        if (prices.get(j) > prices.get(k)) {
            result++;
        }
        if (k < prices.size() - 1) {
            dfs(prices, j, k + 1);
        }
    }

    /**
     * Answer
     *
     * @param prices
     * @return
     */
    public long maxDownSequences(List<Integer> prices) {
        int n = prices.size();
        int dp[][] = new int[3][n], sum = 0;

        // count of decreasing subsequences of size 1
        // ending at each arr[i]
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // building up the matrix dp[][]
        // Here 'l' signifies the size of
        // decreasing subsequnce of size (l+1).
        for (int l = 1; l < 3; l++) {

            // for each decreasing subsequence of size 'l'
            // ending with element arr[i]
            for (int i = l; i < n; i++) {

                // count of decreasing subsequnces of size 'l'
                // ending with element arr[i]
                dp[l][i] = 0;
                for (int j = l - 1; j < i; j++) {
                    if (prices.get(j) > prices.get(i)) {
                        dp[l][i] += dp[l - 1][j];
                    }
                }
            }
        }

        // sum up the count of decreasing subsequences of
        // size 'k' ending at each element arr[i]
        for (int i = 2; i < n; i++) {
            sum += dp[2][i];
        }
        List<Integer> res = new ArrayList<>(Arrays.asList(1, 2));

        // required number of decreasing
        // subsequences of size k
        return sum;
    }
}
