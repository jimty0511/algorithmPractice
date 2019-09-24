package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 699. Falling Squares
public class FallingSquares {

    private class Interval {
        int start, end, height;

        public Interval(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int h = 0;
        for (int[] p : positions) {
            Interval cur = new Interval(p[0], p[0] + p[1] - 1, p[1]);
            h = Math.max(h, getHeight(intervals, cur));
            res.add(h);
        }
        return res;
    }

    private int getHeight(List<Interval> intervals, Interval cur) {
        int preMax = 0;
        for (Interval i : intervals) {
            if (i.end < cur.start)
                continue;
            if (i.start > cur.end)
                continue;
            preMax = Math.max(preMax, i.height);
        }
        cur.height += preMax;
        intervals.add(cur);
        return cur.height;
    }
}
