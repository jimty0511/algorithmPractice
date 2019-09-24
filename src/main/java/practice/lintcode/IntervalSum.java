package practice.lintcode;

import practice.domain.Interval;

import java.util.ArrayList;
import java.util.List;

// 206. Interval Sum
public class IntervalSum {
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
        List<Long> res = new ArrayList<>();
        long[] sum = new long[A.length + 1];
        for (int i = 1; i <= A.length; i++)
            sum[i] = sum[i - 1] + A[i - 1];
        for (Interval q : queries) {
            int start = q.start, end = q.end;
            res.add(sum[end + 1] - sum[start]);
        }
        return res;
    }
}
