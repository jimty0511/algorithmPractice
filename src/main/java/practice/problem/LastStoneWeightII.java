package practice.problem;

// 1049. Last Stone Weight II
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        int sum = 0, res = 100;
        for (int s : stones) {
            sum += s;
            for (int i = sum; i >= s; i--)
                dp[i] |= dp[i - s];
        }
        for (int i = sum / 2; i > 0; i--) {
            if (dp[i])
                return sum - i - i;
        }
        return 0;
    }
}
