package practice.problem;

import java.util.Arrays;

// 456. 132 Pattern
public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        int start = 0;
        while (start < nums.length - 1) {
            while (start < nums.length - 1 && nums[start] >= nums[start + 1])
                start++;
            int m = start + 1;
            while (m < nums.length - 1 && nums[m] < nums[m + 1])
                m++;
            int j = m + 1;
            while (j < nums.length) {
                if (nums[j] > nums[start] && nums[j] < nums[m])
                    return true;
                j++;
            }
            start = m + 1;
        }
        return false;
    }
}
