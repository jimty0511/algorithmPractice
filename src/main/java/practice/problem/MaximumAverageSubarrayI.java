package practice.problem;

// 643. Maximum Average Subarray I
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }

    public double findMaxAverageOnePass(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > k - 1)
                sum -= nums[i - k];
            sum += nums[i];
            if (i >= k - 1)
                max = Math.max(max, sum);
        }
        return (max + 0.0) / k;
    }
}
