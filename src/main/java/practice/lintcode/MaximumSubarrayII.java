package practice.lintcode;

import java.util.List;

// 42. Maximum Subarray II LC
public class MaximumSubarrayII {
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int size = nums.size();
        int[] left = new int[size], right = new int[size];
        int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = size - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < size - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}
