package practice.problem;

import java.util.Arrays;

// 945. Minimum Increment to Make Array Unique
public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0, pre = 0;
        for (int a : A) {
            res += Math.max(pre - a, 0);
            pre = Math.max(a, pre) + 1;
        }
        return res;
    }
}
