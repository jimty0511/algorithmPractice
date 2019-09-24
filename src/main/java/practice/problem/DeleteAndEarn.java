package practice.problem;

// 740. Delete and Earn
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int n : nums)
            count[n] += n;
        int[] dp = new int[10001];
        dp[1] = count[1];
        for (int i = 2; i <= 10000; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i]);
        return dp[10000];
    }
}
