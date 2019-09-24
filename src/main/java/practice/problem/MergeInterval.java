package practice.problem;

import practice.domain.Interval;

import java.util.*;

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

    public List<Interval> mergeTm(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        List<Interval> list = new ArrayList<>();
        int start = 0, cnt = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (cnt == 0)
                start = e.getKey();
            if ((cnt += e.getValue()) == 0)
                list.add(new Interval(start, e.getKey()));
        }
        return list;
    }

    public int[][] mergeTmTwo(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }
        List<int[]> list = new ArrayList<>();
        int start = 0, cnt = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (cnt == 0)
                start = e.getKey();
            if ((cnt += e.getValue()) == 0)
                list.add(new int[]{start, e.getKey()});
        }
        return list.toArray(new int[0][]);
    }

    public List<Interval> mergeThree(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return intervals;
        intervals.sort((a, b) -> a.start - b.start);
        LinkedList<Interval> list = new LinkedList<>();
        for (Interval i : intervals) {
            if (list.isEmpty() || list.getLast().end < i.start) {
                list.add(i);
            } else {
                list.getLast().end = Math.max(i.end, list.getLast().end);
            }
        }
        return list;
    }
}
