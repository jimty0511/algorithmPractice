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

    public int maxProductTwo(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxPre = nums[0], minPre = nums[0], max = nums[0];
        int maxNow, minNow;
        for (int i = 1; i < nums.length; i++) {
            maxNow = Math.max(Math.max(maxPre * nums[i], minPre * nums[i]), nums[i]);
            minNow = Math.min(Math.min(maxPre * nums[i], minPre * nums[i]), nums[i]);
            max = Math.max(maxNow, max);
            maxPre = maxNow;
            minPre = minNow;
        }
        return max;
    }
}
