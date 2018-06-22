package practice.problem;

// 746. Min Cost Climbing Stairs
public class minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int dp0 = 0, dp1 = 0, dp2 = 0;
        for (int i = 2; i <= length; i++) {
            dp2 = Math.min(dp0 + cost[i - 2], dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }

    public int minCostClimbingStairsTwo(int[] cost) {
        int[] res = new int[cost.length];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            res[i] = cost[i] + Math.min(res[i - 1], res[i - 2]);
        }
        return Math.min(res[res.length - 1], res[res.length - 2]);
    }
}
