package practice.problem;

import practice.domain.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

// 759. Employee Free Time
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Interval> res = new ArrayList<>();
        for (List<Interval> s : schedule) {
            for (Interval i : s) {
                map.put(i.start, map.getOrDefault(i.start, 0) + 1);
                map.put(i.end, map.getOrDefault(i.end, 0) - 1);
            }
        }
        int cnt = 0, pre = -1;
        for (int key : map.keySet()) {
            if (pre != -1) {
                res.add(new Interval(pre, key));
                pre = -1;
            }
            cnt += map.get(key);
            if (cnt == 0)
                pre = key;
        }
        return res;
    }

    public List<Interval> employeeFreeTimeTwo(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach(s -> pq.addAll(s));
        Interval tmp = pq.poll();
        while (!pq.isEmpty()) {
            if (tmp.end < pq.peek().start) {
                res.add(new Interval(tmp.end, pq.peek().start));
                tmp = pq.poll();
            } else {
                tmp = tmp.end < pq.peek().end ? pq.peek() : tmp;
                pq.poll();
            }
        }
        return res;
    }
}
