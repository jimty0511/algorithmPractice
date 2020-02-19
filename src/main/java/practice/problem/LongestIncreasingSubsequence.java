package practice.problem;

import java.util.Arrays;

// 300. Longest Increasing Subsequence
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int n : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < n) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = n;
            if (i == size)
                ++size;
        }
        return size;
    }

    public int lengthOfLISdp(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public int longestIncreasingSubsequence(int[] nums) {
        int[] minLast = new int[nums.length + 1];
        minLast[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            // find the first number in minLast >= nums[i]
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
        }
        for (int i = nums.length; i >= 1; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        return 0;
    }

    // find the first number > num
    private int binarySearch(int[] minLast, int num) {
        int start = 0, end = minLast.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (minLast[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
