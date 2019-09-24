package practice.problem;

// 845. Longest Mountain in Array
public class LongestMountainInArray {
    public int longestMountainTwoPass(int[] A) {
        int n = A.length, res = 0;
        int[] up = new int[n], down = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1])
                down[i] = down[i + 1] + 1;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && A[i] > A[i - 1])
                up[i] = up[i - 1] + 1;
            if (up[i] > 0 && down[i] > 0)
                res = Math.max(res, up[i] + down[i] + 1);
        }
        return res;
    }

    public int longestMountainOnePass(int[] A) {
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; i++) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i])
                up = down = 0;
            if (A[i - 1] < A[i])
                up++;
            if (A[i - 1] > A[i])
                down++;
            if (up > 0 && down > 0 && up + down + 1 > res)
                res = up + down + 1;
        }
        return res;
    }
}
