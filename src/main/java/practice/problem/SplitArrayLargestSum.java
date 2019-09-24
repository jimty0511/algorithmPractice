package practice.problem;

// 410. Split Array Largest Sum
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        if (m == 1)
            return (int) sum;
        long l = max, r = sum;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (helper(mid, nums, m))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return (int) l;
    }

    private boolean helper(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int n : nums) {
            total += n;
            if (total > target) {
                total = n;
                count++;
                if (count > m)
                    return false;
            }
        }
        return true;
    }

    public int splitArrayDp(int[] nums, int m) {
        if (nums == null || nums.length == 0)
            return -1;
        int[][] dp = new int[m][nums.length];
        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = nums[i] + dp[0][i - 1];
        }
        for (int k = 1; k < m; k++) {
            for (int i = k; i < nums.length; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++)
                    min = Math.min(min, Math.max(dp[k - 1][j], dp[0][i] - dp[0][j]));
                dp[k][i] = min;
            }
        }
        return dp[m - 1][nums.length - 1];
    }
}
