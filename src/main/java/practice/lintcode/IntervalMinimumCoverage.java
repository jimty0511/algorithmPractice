package practice.lintcode;

import practice.domain.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 1668. Interval Minimum Coverage
public class IntervalMinimumCoverage {
    /**
     * @param a: the array a
     * @return: return the minimal points number
     */
    public int getAns(List<Interval> a) {
        // write your code here
        if (a == null || a.size() == 0)
            return 0;
        int n = a.size();
        Collections.sort(a, new Comparator<Interval>() {
            public int compare(Interval arg0, Interval arg1) {
                if (arg0.start > arg1.start) {
                    return 1;
                } else if (arg0.start < arg1.start) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int res = 1;
        int left = a.get(0).start, right = a.get(0).end;
        for (int i = 1; i < n; i++) {
            if (a.get(i).start <= right) {
                right = Math.min(a.get(i).end, right);
            } else {
                res++;
                left = a.get(i).start;
                right = a.get(i).end;
            }
        }
        return res;
    }
}
