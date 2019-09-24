package practice.problem;

import java.util.Arrays;

// 611. Valid Triangle Number
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int result = 0;
        if (nums == null || nums.length < 3)
            return result;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
