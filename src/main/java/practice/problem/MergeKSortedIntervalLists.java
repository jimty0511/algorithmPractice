package practice.problem;

import practice.domain.Interval;

import java.util.*;

public class MergeKSortedIntervalLists {
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0)
            return res;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (List<Interval> list : intervals) {
            for (Interval interval : list) {
                treeMap.put(interval.start, treeMap.getOrDefault(interval.start, 0) + 1);
                treeMap.put(interval.end, treeMap.getOrDefault(interval.end, 0) - 1);
            }
        }
        int start = 0, cnt = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (cnt == 0)
                start = entry.getKey();
            if ((cnt += entry.getValue()) == 0)
                res.add(new Interval(start, entry.getKey()));
        }
        return res;
    }


    class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public List<Interval> mergeKSortedIntervalListsTwo(List<List<Interval>> intervals) {
        int k = intervals.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, (a, b) ->
                intervals.get(a.row).get(a.col).start - intervals.get(b.row).get(b.col).start);
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).size() > 0)
                pq.offer(new Pair(i, 0));
        }
        List<Interval> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            res.add(intervals.get(pair.row).get(pair.col));
            pair.col++;
            if (pair.col < intervals.get(pair.row).size())
                pq.offer(pair);
        }
        return merge(res);
    }

    private List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        List<Interval> res = new ArrayList<>();
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
