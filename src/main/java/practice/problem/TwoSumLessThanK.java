package practice.problem;

import java.util.Arrays;

// 1099. Two Sum Less Than K
public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int max = -1, low = 0, high = A.length - 1;
        while (low < high) {
            int sum = A[low] + A[high];
            if (sum < K) {
                max = Math.max(sum, max);
                low++;
            } else
                high--;
        }
        return max;
    }
}
