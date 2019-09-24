package practice.problem;

import java.util.Stack;

// 321. Create Maximum Number
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] tmp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(tmp, 0, ans, 0))
                ans = tmp;
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return ans;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] maxArray(int[] nums, int len) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.size() + nums.length - i > len && stack.peek() < nums[i])
                stack.pop();
            if (stack.size() < len)
                stack.push(nums[i]);
        }
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--)
            res[i] = stack.pop();
        return res;
    }
}
