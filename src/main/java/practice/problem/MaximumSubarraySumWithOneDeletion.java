package practice.problem;

// 1186. Maximum Subarray Sum with One Deletion
public class MaximumSubarraySumWithOneDeletion {
    public int maximumSum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int len = arr.length, max = Integer.MIN_VALUE;
        if (len == 1)
            return arr[0];
        int[] left = new int[len], right = new int[len];
        left[0] = arr[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(arr[i], left[i - 1] + arr[i]);
            max = Math.max(max, left[i]);
        }
        right[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1] + arr[i]);
        }
        for (int i = 1; i < len - 1; i++) {
            max = Math.max(max, left[i - 1] + right[i + 1]);
        }
        return max;
    }
}
