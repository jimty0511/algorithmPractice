package practice.lintcode;

import practice.domain.Interval;

import java.util.ArrayList;
import java.util.List;

// 1652. Interval XOR II
public class IntervalXORII {
    /**
     * @param A:
     * @param query:
     * @return: nothing
     */
    public List<Integer> intervalXOR(int[] A, List<Interval> query) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0)
            return res;
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] ^ A[i - 1];
        }
        for (Interval q : query) {
            int start = q.start, end = q.end;
            res.add(preSum[end + start] ^ preSum[start]);
        }
        return res;
    }
}
