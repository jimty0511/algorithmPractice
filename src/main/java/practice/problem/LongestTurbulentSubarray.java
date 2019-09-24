package practice.problem;

import java.util.Arrays;

// 978. Longest Turbulent Subarray
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        int inc = 1, dec = 1, res = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                inc = dec + 1;
                dec = 1;
            } else if (A[i] > A[i + 1]) {
                dec = inc + 1;
                inc = 1;
            } else {
                dec = 1;
                inc = 1;
            }
            res = Math.max(res, Math.max(dec, inc));
        }
        return res;
    }

    public int maxTurbulenceSizeTwo(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int[] inc = new int[A.length];
        int[] dec = new int[A.length];
        int res = 1;
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1])
                inc[i] = dec[i - 1] + 1;
            else if (A[i] < A[i - 1])
                dec[i] = inc[i - 1] + 1;
            res = Math.max(res, Math.max(inc[i], dec[i]));
        }
        return res;
    }
}
