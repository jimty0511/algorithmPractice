package practice.problem;

import practice.domain.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MeetingTime {
    public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (List<Interval> intervalList : intervals) {
            for (Interval interval : intervalList) {
                treeMap.put(interval.start, treeMap.getOrDefault(interval.start, 0) + 1);
                treeMap.put(interval.end, treeMap.getOrDefault(interval.end, 0) - 1);
            }
        }
        List<Interval> res = new ArrayList<>();
        int cnt = 0;
        Integer start = null;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            cnt += entry.getValue();
            if (cnt == 0 && start == null)
                start = entry.getKey();
            if (cnt != 0 && start != null) {
                res.add(new Interval(start, entry.getKey()));
                start = null;
            }
        }
        return res;
    }
}
