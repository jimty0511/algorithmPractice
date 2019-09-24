package practice.problem;

import java.util.Stack;

// 962. Maximum Width Ramp
public class MaximumWidthRamp {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i])
                stack.add(i);
        }
        for (int i = n - 1; i > res; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i])
                res = Math.max(res, i - stack.pop());
        }
        return res;
    }

    public int maxWidthRampTwo(int[] A) {
        int n = A.length, max = 0;
        int i, j;
        int[] maxR = new int[n], minL = new int[n];
        minL[0] = A[0];
        for (i = 1; i < n; i++) {
            minL[i] = Math.min(A[i], minL[i - 1]);
        }
        maxR[n - 1] = A[n - 1];
        for (j = n - 2; j >= 0; j--) {
            maxR[j] = Math.max(A[j], maxR[j + 1]);
        }
        i = 0;
        j = 0;
        while (i < n && j < n) {
            if (minL[i] <= maxR[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }
        }
        return max;
    }
}
