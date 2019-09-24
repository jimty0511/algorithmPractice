package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 413. Arithmetic Slices
public class ArithmeticSlices {
    public int numberOfArithmeticSlicesDpConstant(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        int count = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlicesDp(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
}
