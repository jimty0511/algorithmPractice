package practice.problem;

import java.util.Stack;

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

    public boolean find132patternTwo(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    s3 = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
