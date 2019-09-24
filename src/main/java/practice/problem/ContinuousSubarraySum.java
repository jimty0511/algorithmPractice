package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 523. Continuous Subarray Sum

/**
 * Running sum from first element to index i : sum_i. If we mod k, it will be some format like : sum_i = k * x + modk_1
 * Running sum from first element to index j : sum_j. If we mod k, it will be some format like : sum_j = k * y + modk_2
 * If they have the same mod, which is modk_1 == modk_2, subtracting these two running sum we get the difference
 * sum_i - sum_j = (x - y) * k = constant * k, and the difference is the sum of elements between index i and j,
 * and the value is a multiple of k.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0)
                runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1)
                    return true;
            } else {
                map.put(runningSum, i);
            }
        }
        return false;
    }

    public boolean checkSubarraySumEz(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++)
            preSum[i] = preSum[i - 1] + nums[i - 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 2; j <= nums.length; j++) {
                if (k == 0) {
                    if (preSum[j] - preSum[i] == 0)
                        return true;
                } else if ((preSum[j] - preSum[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
