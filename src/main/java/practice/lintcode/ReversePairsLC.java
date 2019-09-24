package practice.lintcode;

import java.util.Arrays;

public class ReversePairsLC {
    public long reversePairs(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private int mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int sum = 0;
        sum += mergeSort(A, start, mid);
        sum += mergeSort(A, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && A[i] > A[j])
                j++;
            sum += j - (mid + 1);
        }
        Arrays.sort(A, start, end + 1);
        return sum;
    }
}
