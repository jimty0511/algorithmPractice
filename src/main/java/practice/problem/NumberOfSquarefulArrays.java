package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 996. Number of Squareful Arrays
public class NumberOfSquarefulArrays {

    private int cnt = 0;

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        helper(new ArrayList<>(), A, new boolean[A.length], -1);
        return cnt;
    }

    private void helper(List<Integer> temp, int[] A, boolean[] used, int last) {
        if (temp.size() == A.length)
            cnt++;
        else {
            for (int i = 0; i < A.length; i++) {
                if (used[i] || (i > 0 && A[i] == A[i - 1] && !used[i - 1]))
                    continue;
                if (last != -1) {
                    if (!isSquare(A[i], last))
                        continue;
                }
                used[i] = true;
                temp.add(A[i]);
                helper(temp, A, used, A[i]);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    private boolean isSquare(int a, int b) {
        double sqrt = Math.sqrt(a + b);
        return 0 == sqrt - Math.floor(sqrt);
    }
}
