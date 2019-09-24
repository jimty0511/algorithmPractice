package practice.problem;

import java.util.Arrays;

// https://leetcode.com/discuss/interview-question/241808/Google-Two-sum-closest
public class TwoSumClosest {
    public int[] twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int minDiff = Integer.MAX_VALUE;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int diff = target - (nums[l] + nums[r]);
            if (diff > 0) {
                if (diff < minDiff) {
                    minDiff = diff;
                    res[0] = nums[l];
                    res[1] = nums[r];
                }
                l++;
            } else if (diff < 0)
                r--;
            else {
                res[0] = nums[l];
                res[1] = nums[r];
                break;
            }
        }
        return res;
    }
}
