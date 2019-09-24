package practice.problem;

public class DeleteColumnsToMakeSortedII {
    public int minDeletionSize(String[] A) {
        int res = 0, m = A.length, n = A[0].length(), i, j;
        boolean[] sorted = new boolean[m - 1];
        for (j = 0; j < n; j++) {
            for (i = 0; i < m - 1; i++) {
                if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    res++;
                    break;
                }
            }
            if (i < m - 1)
                continue;
            for (i = 0; i < m - 1; i++) {
                if (A[i].charAt(j) < A[i + 1].charAt(j))
                    sorted[i] = true;
            }
        }
        return res;
    }
}
