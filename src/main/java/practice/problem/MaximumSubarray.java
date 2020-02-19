package practice.problem;

// 53. Maximum Subarray
// Microsoft ladder
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] > nums[i] + dp[i - 1] ? nums[i] : nums[i] + dp[i - 1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArrayTwo(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArrayThree(int[] A) {
        int maxSoFar = A[0], maxEndHere = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndHere = Math.max(maxEndHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }
}
