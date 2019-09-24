package practice.problem;

import practice.domain.Interval;

import java.util.Map;
import java.util.TreeMap;

// 436. Find Right Interval
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++)
            treeMap.put(intervals[i].start, i);
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i].end);
            res[i] = entry != null ? entry.getValue() : -1;
        }
        return res;
    }
}
