package practice.problem;

// 918. Maximum Sum Circular Subarray
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = Integer.MIN_VALUE, curMax = 0, minSum = Integer.MAX_VALUE, curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public int maxSubarraySumCircularTwo(int[] A) {
        int max = Integer.MIN_VALUE, maxEndHere = 0, min = Integer.MAX_VALUE, minEndHere = 0, total = 0;
        for (int a : A) {
            maxEndHere = Math.max(maxEndHere + a, a);
            max = Math.max(max, maxEndHere);
            minEndHere = Math.min(minEndHere + a, a);
            min = Math.min(min, minEndHere);
            total += a;
        }
        if (max < 0)
            return max;
        return Math.max(max, total - min);
    }
}
