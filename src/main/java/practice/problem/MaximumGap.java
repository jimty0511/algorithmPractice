package practice.problem;

import java.util.Arrays;

// 164. Maximum Gap
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int min = nums[0], max = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int n : nums) {
            if (n == min || n == max)
                continue;
            int idx = (n - min) / gap;
            bucketMin[idx] = Math.min(n, bucketMin[idx]);
            bucketMax[idx] = Math.max(n, bucketMax[idx]);
        }

        int maxGap = Integer.MIN_VALUE;
        int pre = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE || bucketMax[i] == Integer.MIN_VALUE)
                continue;
            maxGap = Math.max(maxGap, bucketMin[i] - pre);
            pre = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }

    public int maximumGapRadixSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int m = nums[0];
        for (int n : nums) {
            m = Math.max(m, n);
        }
        int exp = 1;
        int[] out = new int[nums.length];
        while (m / exp > 0) {
            int[] count = new int[10];
            for (int i = 0; i < nums.length; i++) {
                int digit = (nums[i] / exp) % 10;
                count[digit]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                out[count[digit] - 1] = nums[i];
                count[digit]--;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = out[i];
            }
            exp *= 10;
        }
        int max = 0;
        for (int i = 1; i < out.length; i++) {
            max = Math.max(max, out[i] - out[i - 1]);
        }
        return max;
    }
}
