package practice.lintcode;

// 724. Minimum Partition Lintcode
public class MinimumPartition {
    public int findMin(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            for (int j = sum; j >= i; j--) {
                dp[j] |= dp[j - i];
                if (dp[j]) {
                    int diff = Math.abs(sum - j * 2);
                    min = Math.min(min, diff);
                }
            }
        }
        return min;
    }
}
