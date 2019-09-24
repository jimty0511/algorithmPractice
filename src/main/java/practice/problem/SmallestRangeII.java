package practice.problem;

import java.util.Arrays;

public class SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int res = A[n - 1] - A[0];
        int left = A[0] + K, right = A[n - 1] - K;
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(A[i] + K, right);
            int min = Math.min(A[i + 1] - K, left);
            res = Math.min(res, max - min);
        }
        return res;
    }
}
