package practice.problem;

// 152. Maximum Product Subarray
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] maxdp = new int[n + 1];
        int[] mindp = new int[n + 1];
        int max = Integer.MIN_VALUE;
        maxdp[0] = 1;
        mindp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            maxdp[i] = Math.max(maxdp[i - 1] * nums[i - 1], Math.max(mindp[i - 1] * nums[i - 1], nums[i - 1]));
            mindp[i] = Math.min(maxdp[i - 1] * nums[i - 1], Math.min(mindp[i - 1] * nums[i - 1], nums[i - 1]));
            max = Math.max(max, maxdp[i]);
        }
        return max;
    }
}
