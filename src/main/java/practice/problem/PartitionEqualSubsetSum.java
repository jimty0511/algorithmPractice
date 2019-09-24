package practice.problem;

// 416. Partition Equal Subset Sum
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int j = sum; j >= n; j--)
                dp[j] = dp[j] || dp[j - n];
        }
        return dp[sum];
    }
}
