package practice.problem;

import practice.domain.Interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 56. Merge Intervals
public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
