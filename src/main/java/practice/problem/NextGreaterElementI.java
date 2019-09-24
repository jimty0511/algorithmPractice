package practice.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 496. Next Greater Element I
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public int[] nextGreaterElementTwo(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while (!stk.isEmpty() && nums[stk.peek()] < n) {
                res[stk.pop()] = n;
            }
            stk.push(i);
        }
        return res;
    }
}
