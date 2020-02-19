package practice.problem;

import java.util.Arrays;

// 805. Split Array With Same Average
//  totalSum/n = Asum/k = Bsum/(n-k), where k = A.size() and 1 <= k <= n/2;
//  Asum = totalSum*k/n, which is an integer. So we have totalSum*k%n == 0;
public class SplitArrayWithSameAverage {
    public boolean splitArraySameAverage(int[] A) {
        int sum = Arrays.stream(A).sum();
        int n = A.length;
        Arrays.sort(A);
        for (int lenOfA = 1; lenOfA <= n / 2; lenOfA++) {
            if (sum * lenOfA % n == 0 && combinationSum(A, 0, lenOfA, sum * lenOfA / n))
                return true;
        }
        return false;
    }

    private boolean combinationSum(int[] A, int idx, int k, int leftSum) {
        if (k == 0)
            return leftSum == 0;
        if (A[idx] > leftSum / k)
            return false;
        for (int i = idx; i < A.length - k + 1; i++) {
            if (i > idx && A[i] == A[i - 1])
                continue;
            if (A[i] <= leftSum && combinationSum(A, i + 1, k - 1, leftSum - A[i]))
                return true;
        }
        return false;
    }
}
