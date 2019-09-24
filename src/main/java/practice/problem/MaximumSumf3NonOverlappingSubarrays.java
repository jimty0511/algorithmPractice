package practice.problem;

// 689. Maximum Sum of 3 Non-Overlapping Subarrays
public class MaximumSumf3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxSum = 0;
        int[] sum = new int[n + 1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
        for (int i = 0; i < n; i++)
            sum[i + 1] = nums[i] + sum[i];
        for (int i = k, total = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > total) {
                posLeft[i] = i + 1 - k;
                total = sum[i + 1] - sum[i + 1 - k];
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }
        posRight[n - k] = n - k;
        for (int i = n - k - 1, total = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= total) {
                posRight[i] = i;
                total = sum[i + k] - sum[i];
            } else {
                posRight[i] = posRight[i + 1];
            }
        }
        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i - 1], r = posRight[i + k];
            int total = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (total > maxSum) {
                maxSum = total;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }

    public int[] maxSumOfThreeSubarraysTwo(int[] nums, int k) {
        int[] sums = new int[nums.length - k + 1], left = new int[nums.length - k + 1], right = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k)
                sum -= nums[i - k];
            if (i >= k - 1)
                sums[i - k + 1] = sum;
        }
        int best = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[best])
                best = i;
            left[i] = best;
        }
        best = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[best])
                best = i;
            right[i] = best;
        }
        int[] ans = new int[]{-1, -1, -1};
        for (int m = k; m < sums.length - k; m++) {
            int l = left[m - k], r = right[m + k];
            if (ans[0] == -1 || sums[l] + sums[m] + sums[r] > sums[ans[0]] + sums[ans[1]] + sums[ans[2]]) {
                ans[0] = l;
                ans[1] = m;
                ans[2] = r;
            }
        }
        return ans;
    }
}
