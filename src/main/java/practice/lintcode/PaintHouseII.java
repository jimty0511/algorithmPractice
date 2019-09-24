package practice.lintcode;

// 516. Paint House II
public class PaintHouseII {

    class Color {
        int idx;
        int cost;

        public Color(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public int minCostII(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++)
            dp[0][i] = costs[0][i];
        for (int i = 1; i < n; i++) {
            Color firstMin = new Color(0, Integer.MAX_VALUE);
            Color secondMin = new Color(0, Integer.MAX_VALUE);
            for (int l = 0; l < k; l++) {
                if (dp[i - 1][l] < firstMin.cost) {
                    firstMin.cost = dp[i - 1][l];
                    firstMin.idx = l;
                }
            }
            for (int l = 0; l < k; l++) {
                if (l == firstMin.idx)
                    continue;
                if (dp[i - 1][l] < secondMin.cost) {
                    secondMin.cost = dp[i - 1][l];
                    secondMin.idx = l;
                }
            }
            for (int j = 0; j < k; j++) {
                if (j == firstMin.idx)
                    dp[i][j] = secondMin.cost + costs[i][j];
                else
                    dp[i][j] = firstMin.cost + costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

    public int minCostIITwo(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            int preMin1 = min1, preMin2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < k; j++) {
                if (j != preMin1) {
                    costs[i][j] += preMin1 < 0 ? 0 : costs[i - 1][preMin1];
                } else {
                    costs[i][j] += preMin2 < 0 ? 0 : costs[i - 1][preMin2];
                }
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2])
                    min2 = j;
            }
        }
        return costs[n - 1][min1];
    }
}
