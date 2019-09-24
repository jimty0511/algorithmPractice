package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 446. Arithmetic Slices II - Subsequence
public class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] maps = new Map[A.length];
        for (int i = 0; i < A.length; i++) {
            maps[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;
                int d = (int) diff;
                int c1 = maps[i].getOrDefault(d, 0);
                int c2 = maps[j].getOrDefault(d, 0);
                res += c2;
                maps[i].put(d, c1 + c2 + 1);
            }
        }
        return res;
    }
}
