package practice.problem;

import java.util.Arrays;

// 628. Maximum Product of Three Numbers
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int b = nums[0] * nums[1] * nums[n - 1];
        return Math.max(a, b);
    }

    public int maximumProductTwo(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                max3 = n;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
