package practice.problem;

import practice.domain.Interval;

import java.util.Arrays;

// 435. Non-overlapping Intervals
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a.end != b.end ? a.end - b.end : b.start - a.start);
        int end = Integer.MIN_VALUE;
        int count = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end)
                end = interval.end;
            else
                count++;
        }
        return count;
    }
}
