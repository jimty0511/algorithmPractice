package practice.problem;

// 1031. Maximum Sum of Two Non-Overlapping Subarrays
public class MaximumSumOfTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++)
            sum[i] = sum[i - 1] + A[i];
        int res = sum[L + M - 1], Lmax = sum[L - 1], Mmax = sum[M - 1];
        for (int i = L + M; i < A.length; i++) {
            Lmax = Math.max(Lmax, sum[i - M] - sum[i - M - L]);
            Mmax = Math.max(Mmax, sum[i - L] - sum[i - M - L]);
            res = Math.max(res, Math.max(Lmax + sum[i] - sum[i - M], Mmax + sum[i] - sum[i - L]));
        }
        return res;
    }
}
