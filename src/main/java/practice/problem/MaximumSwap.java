package practice.problem;

import java.util.Stack;

// 670. Maximum Swap
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }

    public int maximumSwapTwo(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Stack<Integer> stk = new Stack<>();
        int left = digits.length;
        for (int i = 0; i < digits.length; i++) {
            while (!stk.isEmpty() && digits[stk.peek()] < digits[i]) {
                int idx = stk.pop();
                left = Math.min(idx, left);
            }
            stk.push(i);
        }
        if (left < digits.length) {
            int right = -1;
            char max = digits[left];
            for (int i = left; i < digits.length; i++) {
                if (digits[i] >= max) {
                    right = i;
                    max = digits[i];
                }
            }
            char tmp = digits[left];
            digits[left] = digits[right];
            digits[right] = tmp;
        }
        return Integer.parseInt(new String(digits));
    }
}
