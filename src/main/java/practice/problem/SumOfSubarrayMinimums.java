package practice.problem;

import java.util.Stack;

// 907. Sum of Subarray Minimums
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int len = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[len], right = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = i + 1;
            right[i] = len - i;
        }
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i])
                stack.pop();
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                right[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        int ans = 0;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < len; i++) {
            ans = (ans + A[i] * left[i] * right[i]) % mod;
        }
        return ans;
    }
}
