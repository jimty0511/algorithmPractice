package practice.problem;

import java.util.Arrays;

// 891. Sum of Subsequence Widths
public class SumOfSubsequenceWidths {
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long c = 1, res = 0, mod = (long) 1e9 + 7;
        for (int i = 0; i < A.length; i++, c = (c << 1) % mod) {
            res = (res + A[i] * c) % mod;
            res = (res - A[A.length - i - 1] * c) % mod;
        }
        return (int) ((res + mod) % mod);
    }
}
