package practice.problem;

import practice.domain.Interval;

import java.util.*;

// 57. Insert Interval
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            res.add(intervals.get(i++));
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size())
            res.add(intervals.get(i++));
        return res;
    }

    public int[][] insertTwo(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            res.add(intervals[i++]);
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]),
                    Math.max(intervals[i][1], newInterval[1])};
            i++;
        }
        res.add(newInterval);
        while (i < intervals.length)
            res.add(intervals[i++]);
        return res.toArray(new int[0][]);
    }
}
