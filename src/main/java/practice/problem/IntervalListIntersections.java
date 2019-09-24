package practice.problem;

import practice.domain.Interval;

import java.util.ArrayList;
import java.util.List;

// 986. Interval List Intersections
public class IntervalListIntersections {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return new Interval[]{};
        int m = A.length, n = B.length;
        int i = 0, j = 0;
        List<Interval> res = new ArrayList<>();
        while (i < m && j < n) {
            Interval a = A[i], b = B[j];
            int startMax = Math.max(a.start, b.start);
            int endMin = Math.min(a.end, b.end);
            if (endMin >= startMax)
                res.add(new Interval(startMax, endMin));
            if (a.end == endMin)
                i++;
            if (b.end == endMin)
                j++;
        }
        return res.toArray(new Interval[0]);
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return new int[][]{};
        int m = A.length, n = B.length;
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < m && j < n) {
            int[] a = A[i], b = B[j];
            int startMax = Math.max(a[0], b[0]);
            int endMin = Math.min(a[1], b[1]);
            if (endMin >= startMax)
                res.add(new int[]{startMax, endMin});
            if (a[1] == endMin)
                i++;
            if (b[1] == endMin)
                j++;
        }
        return res.toArray(new int[0][]);
    }
}
